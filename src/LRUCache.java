import java.util.HashMap;
import java.util.Map;
 
public class LRUCache {
     
    private DoublyLinkedList pageList;
    private Map<Integer, NodeLRU> pageMap;
    private final int cacheSize;
     
    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        pageList = new DoublyLinkedList(cacheSize);
        pageMap = new HashMap<Integer, NodeLRU>();
    }
     
    public void accessPage(int pageNumber) {
        NodeLRU pageNode = null;
        if(pageMap.containsKey(pageNumber)) {
            // If page is present in the cache, move the page to the start of list
            pageNode = pageMap.get(pageNumber);
            pageList.movePageToHead(pageNode);
        } else {
            // If the page is not present in the cache, add the page to the cache
            if(pageList.getCurrSize() == pageList.getSize()) {
                // If cache is full, we will remove the tail from the cache pageList
                // Remove it from map too
                pageMap.remove(pageList.getTail().getPageNumber());
            }
            pageNode = pageList.addPageToList(pageNumber);
            pageMap.put(pageNumber, pageNode);
        }
    }
     
    public void printCacheState() {
        pageList.printList();
        System.out.println();
    }
 
    public static void main(String[] args) {
        int cacheSize = 4;
        LRUCache cache = new LRUCache(cacheSize);
        cache.accessPage(4);
        cache.printCacheState();
        cache.accessPage(2);
        cache.printCacheState();
        cache.accessPage(1);
        cache.printCacheState();
        cache.accessPage(1);
        cache.printCacheState();
        cache.accessPage(4);
        cache.printCacheState();
        cache.accessPage(3);
        cache.printCacheState();
        cache.accessPage(7);
        cache.printCacheState();
        cache.accessPage(8);
        cache.printCacheState();
        cache.accessPage(3);
        cache.printCacheState();
    }
}
 
class DoublyLinkedList {
     
    private final int size;
    private int currSize;
    private NodeLRU head;
    private NodeLRU tail;
 
    public DoublyLinkedList(int size) {
        this.size = size;
        currSize = 0;
    }
 
    public NodeLRU getTail() {
        return tail;
    }
 
    public void printList() {
        if(head == null) {
            return;
        }
        NodeLRU tmp = head;
        while(tmp != null) {
            System.out.print(tmp);
            tmp = tmp.getNext();
        }
    }
 
    public NodeLRU addPageToList(int pageNumber) {
        NodeLRU pageNode = new NodeLRU(pageNumber);       
        if(head == null) {
            head = pageNode;
            tail = pageNode; 
            currSize = 1;
            return pageNode;
        } else if(currSize < size) {
            currSize++;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        pageNode.setNext(head);
        head.setPrev(pageNode);
        head = pageNode;
        return pageNode;
    }
 
    public void movePageToHead(NodeLRU pageNode) {
        if(pageNode == null || pageNode == head) {
            return;
        }
 
        if(pageNode == tail) {
            tail = tail.getPrev();
            tail.setNext(null);
        }
         
        NodeLRU prev = pageNode.getPrev();
        NodeLRU next = pageNode.getNext();
        prev.setNext(next);
 
        if(next != null) {
            next.setPrev(prev);
        }
 
        pageNode.setPrev(null);
        pageNode.setNext(head);
        head.setPrev(pageNode);
        head = pageNode;    
    }
 
    public int getCurrSize() {
        return currSize;
    }
 
    public void setCurrSize(int currSize) {
        this.currSize = currSize;
    }
 
    public NodeLRU getHead() {
        return head;
    }
 
    public void setHead(NodeLRU head) {
        this.head = head;
    }
 
    public int getSize() {
        return size;
    }   
}
 
class NodeLRU {
     
    private int pageNumber;
    private NodeLRU prev;
    private NodeLRU next;
     
    public NodeLRU(int pageNumber) {
        this.pageNumber = pageNumber;
    }
 
    public int getPageNumber() {
        return pageNumber;
    }
 
    public void setPageNumber(int data) {
        this.pageNumber = data;
    }
     
    public NodeLRU getPrev() {
        return prev;
    }
 
    public void setPrev(NodeLRU prev) {
        this.prev = prev;
    }
 
    public NodeLRU getNext() {
        return next;
    }
 
    public void setNext(NodeLRU next) {
        this.next = next;
    }
     
    public String toString() {
        return pageNumber + "  ";
    }
}

/*
public class LRUCache {
    private class Node{
        int key, value;
        Node prev, next;
        Node(int k, int v){
            this.key = k;
            this.value = v;
        }
        Node(){
            this(0, 0);
        }
    }
    private int capacity, count;
    private Map<Integer, Node> map;
    private Node head, tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node n = map.get(key);
        if(null==n){
            return -1;
        }
        update(n);
        return n.value;
    }
    
    public void set(int key, int value) {
        Node n = map.get(key);
        if(null==n){
            n = new Node(key, value);
            map.put(key, n);
            add(n);
            ++count;
        }
        else{
            n.value = value;
            update(n);
        }
        if(count>capacity){
            Node toDel = tail.prev;
            remove(toDel);
            map.remove(toDel.key);
            --count;
        }
    }
    
    private void update(Node node){
        remove(node);
        add(node);
    }
    private void add(Node node){
        Node after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
    }
    
    private void remove(Node node){
        Node before = node.prev, after = node.next;
        before.next = after;
        after.prev = before;
    }
}
 */

/*Linked hashmap
 * 
 * 
 * public class LRUCache {
    
    private Map<Integer, Integer> map;
    
    public LRUCache(int capacity) {
        map = new LinkedCappedHashMap<>(capacity);
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) { return -1; }
        return map.get(key);
    }
    
    public void set(int key, int value) {
        map.put(key,value);
    }

    private static class LinkedCappedHashMap<K,V> extends LinkedHashMap<K,V> {
        
        int maximumCapacity;
        
        LinkedCappedHashMap(int maximumCapacity) {
            super(maximumCapacity, 0.75f, true);
            this.maximumCapacity = maximumCapacity;
        }
        
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > maximumCapacity;
        }
    }
}*/
 
        