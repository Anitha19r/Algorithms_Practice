import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class MyObject<K,V>{
	K key;
	V value;
	
	MyObject(K key, V value){
		this.key = key;
		this.value = value;
	}
	
	
	public String toString(){
		return "Key: " + key + " Value: "+ value;
	}
}

public class HashMapImpl<K,V> {
	ArrayList<LinkedList<MyObject<K,V>>> arrayList = new ArrayList<LinkedList<MyObject<K,V>>>(16);
	int capacity;
	public HashMapImpl(){
		capacity = 16;
		arrayList.ensureCapacity(capacity);
		for(int i = 0; i<capacity; i++){
			arrayList.add(new LinkedList<MyObject<K,V>>());
		}
	}
	
	public int returnIndex(K key){
		int hashCode = key.hashCode();
		return hashCode % capacity;
	}
	
	public V put(K key, V value){
		MyObject<K,V> mObject = new MyObject<K,V>(key,value);
		LinkedList<MyObject<K,V>> ll = arrayList.get(returnIndex(mObject.key));
		Iterator<MyObject<K,V>> iter = ll.iterator();
		boolean flag = false;
		while(iter.hasNext()){
			MyObject<K,V> obj = iter.next();
			if(obj.key.equals(mObject.key)){
				obj.value = mObject.value;
				flag = true;
			}
		}
		if(flag == false)
			ll.add(mObject);
		return mObject.value;
	}
	
	/*public boolean contains(MyObject<K,V> myObject){
		LinkedList<MyObject<K,V>> ll = arrayList.get(returnIndex(myObject.key));
		Iterator<MyObject<K,V>> iter = ll.iterator();
		while(iter.hasNext()){
			MyObject<K,V> obj = iter.next();
			if(obj.key.equals(myObject.key) && obj.value.equals(myObject.value)){
				return true;
			}
		}
		return false;
	}*/
	public boolean containsKey(K key){
		LinkedList<MyObject<K,V>> ll = arrayList.get(returnIndex(key));
		Iterator<MyObject<K,V>> iter = ll.iterator();
		while(iter.hasNext()){
			MyObject<K,V> obj = iter.next();
			if(obj.key.equals(key)){
				return true;
			}
		}
		return false;
	}
	
	public boolean containsValue(V value){
		for(int i = 0; i<arrayList.size() ; i++){
			LinkedList<MyObject<K,V>> ll = arrayList.get(i);
			if(ll.size() != 0){
				for(int j = 0; j<ll.size(); j++){
					MyObject<K,V> myObject = ll.get(j);
					if(myObject.value.equals(value))
						return true;
				}
			}
		}
		return false;
	}
	
	public V get(K key){
		V value = null;
		LinkedList<MyObject<K,V>> ll = arrayList.get(returnIndex(key));
		Iterator<MyObject<K,V>> iter = ll.iterator();
		while(iter.hasNext()){
			MyObject<K,V> obj = iter.next();
			if(obj.key.equals(key)){
				value = obj.value;
			}
		}
		return value;
	}
	
	public V remove(K key){
		V value = null;
		LinkedList<MyObject<K,V>> ll = arrayList.get(returnIndex(key));
		Iterator<MyObject<K,V>> iter = ll.iterator();
		MyObject<K,V> obj = null;
		while(iter.hasNext()){
			obj = iter.next();
			if(obj.key.equals(key)){
				value = obj.value;
				break;
			}
		}
		if(obj != null)
			ll.remove(obj);
		return value;
	}
	
	public boolean remove(K key, V value){
		boolean flag = false;
		LinkedList<MyObject<K,V>> ll = arrayList.get(returnIndex(key));
		Iterator<MyObject<K,V>> iter = ll.iterator();
		MyObject<K,V> obj = null;
		while(iter.hasNext()){
			obj = iter.next();
			if(obj.key.equals(key) && obj.value.equals(value)){
				flag = true;
				break;
			}
		}
		if(obj != null && flag == true)
			ll.remove(obj);
		return flag;
	}
	
	public void display(){
		for(int i = 0; i<arrayList.size(); i++){
			System.out.println(arrayList.get(i));
		}
	}
	
	public static void main(String[] args){
		
		HashMapImpl<Integer, String> hashMap = new HashMapImpl<Integer, String>();
		hashMap.put(1, "Hussain");
		hashMap.put(2, "Taha");
		hashMap.put(3, "Sanchit");
		hashMap.put(3, "Mark");		
		
		hashMap.display();
		
		//System.out.println(hashMap.contains(new MyObject<Integer, String>(1, "Hussain")));
		//System.out.println(hashMap.remove(3));
		//System.out.println(hashMap.remove(4));
		System.out.println(hashMap.remove(3,"Sanchit"));
		hashMap.display();
		System.out.println(hashMap.remove(3,"Mark"));
		hashMap.display();
		
		
	}
}


/*
public class HashMapImpl {

// The initial size of the bucket array //
private int BUCKET_ARRAY_SIZE = 256;
private Node bucketArray[] = new Node[BUCKET_ARRAY_SIZE];

// Constructors //
public HashMapImpl(){}

public HashMapImpl(int initialSize){
    this.BUCKET_ARRAY_SIZE = initialSize;
}

//
 * Used to put a key-value pair into the data structure.
 * @param key Key string that is used identify the key-value pair
 * @param value Value string in which the key string maps to.
 //
public void put(String key, String value){
    // Get the hash code //
    int hash = Math.abs(key.hashCode() % BUCKET_ARRAY_SIZE);
    // Create the Node to add to the linked list //
    Node entry = new Node(key,value);

    // Insert the node to the bucket array at the hash index 
    if(bucketArray[hash] == null){
        // No collision detected. Insert the node. 
        bucketArray[hash] = entry;
    }else{
        // Collision detected. We must place the node at the end of the linked list. 
        Node current = bucketArray[hash];
        while(current.next != null){
            // Check if the key already exists 
            if(current.getKey().equals(entry.getKey())){
                // Replace the keys value with the new one 
                current.setValue(entry.getValue());
                return;
            }
            current = current.next;
        }
        //When the code gets here current.next == null 
        // Insert the node 
        current.next = entry;
    }
}

public String get(String key){
    // Get the hash 
    int hash = Math.abs(key.hashCode() % BUCKET_ARRAY_SIZE);
    // Search for key in linked list 
    Node n = bucketArray[hash];
    // Traverse linked list 
    while(n != null){
        if(n.getKey().equals(key)){
            return n.getValue();
        }
        n = n.getNext();
    }
    // Not found? then return null 
    return null;
}


// This is the simple object that we use to store each key-value pair 
class Node{
    private String key;
    private String value;
    private Node next;

    public Node(){}

    public Node(String key, String value){
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
public static void main(String[] args){
	HashMapImpl h= new HashMapImpl();
	String k = "TestPutGet";
    String v = "TestPutGetValue";
    h.put(k, v);
    String valueResult = h.get(k);
    System.out.println(valueResult);
}
}*/