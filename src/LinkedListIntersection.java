/*
1. Find length of list1 - use a tmp1 node starting from head of list1 and move till last node.
2. Find length of list2 - use a tmp2 node starting from head of list2 and move till last node.
3. If tmp1 and tmp2 are different, it means that linked lists are non-intersecting. Return null.
   Example: list1: 1-2-3-4 , list2: 5-6-7-8, last nodes are different.
4. Else set variables diff, tmp1 and tmp2 as:
   a). tmp1 (a list node) to head node of larger list.
   b). tmp2 (a list node) to head node of smaller list.
   c). diff (an integer) to difference of lengths of larger to smaller lists i.e. absolute difference of the lengths.
5. Move forward tmp1 by diff number of nodes.
6. Now lists starting from tmp1 and tmp2 have same number of nodes and intersect at a particular node. Therefore, both tmp1 and tmp2 are equidistant from the intersection node.
7. Starting from tmp1 and tmp2 simultaneously, move node by node till a common node is reached. This node is the intersection of the 2 list
Complexity == O(m+n)
*/

public class LinkedListIntersection {
    
    private Node head; 
     
    public void addToList(int num) {
         
        if(head == null) {
            head = new Node(num);
            return;
        }
         
        Node tmp = head;
        while(tmp.getNext() != null) {
            tmp = tmp.getNext();
        }
        tmp.setNext(new Node(num));
    }
 
    /**
     * Find intersection of two Linked Lists - O(m + n) Time Complexity and O(1) Space Complexity
     * @param list1
     * @param list2
     * @return intersection node if found, else null
     */
    public static Node getIntersection(LinkedListIntersection list1, LinkedListIntersection list2) {
         
        // Get length of list 1
        int length1 = 0;
        Node tmp1 = list1.getHead();
        while(tmp1.getNext() != null) {
            length1++;
            tmp1 = tmp1.getNext();      
        }
         
        // Get length of list 2
        int length2 = 0;
        Node tmp2 = list2.getHead();
        while(tmp2.getNext() != null) {
            length2++;
            tmp2 = tmp2.getNext();      
        }
         
        if(tmp1 != tmp2) {
            return null;
        }
 
        int diff = 0;
        if(length1 > length2) {
            tmp1 = list1.getHead();
            tmp2 = list2.getHead();
            diff = length1 - length2;
        } else {
            tmp1 = list2.getHead();
            tmp2 = list1.getHead();
            diff = length2 - length1;
        }
        while(diff > 0) {
            tmp1 = tmp1.getNext();
            diff--;
        }
        while(tmp1 != tmp2) {
            tmp1 = tmp1.getNext();
            tmp2 = tmp2.getNext();
        }
        return tmp1;
    }
 
    public Node getHead() {
        return head;
    }
     
    public void setHead(Node head) {
        this.head = head;
    }
     
    // Main method to test
    public static void main(String[] args) {
         
        // List 1 having numbers 1 - 5
        LinkedListIntersection list1 = new LinkedListIntersection();
        int i = 1;
        int n = 5;
        while(i <= n) {
            list1.addToList(i);
            i++;
        }
         
        // List 2 having numbers 11 - 15
        LinkedListIntersection list2 = new LinkedListIntersection();
        i = 11;
        n = 15;
        while(i <= n) {
            list2.addToList(i);
            i++;
        }
         
        // code to mock intersection by adding node 5 to end of list 2
        Node tmp1 = list1.getHead();
        i = 1;
        n = 5;
        while(i < n) {
            tmp1 = tmp1.getNext();
            i++;
        }
         
        Node tmp2 = list2.getHead();
        while(tmp2.getNext() != null) {
            tmp2 = tmp2.getNext();
        }
        tmp2.setNext(tmp1);
         
        Node intersection = LinkedListIntersection.getIntersection(list1, list2);
        if(intersection != null) {
            System.out.println("Intersection of linked lists found at Node " + intersection.getData());
        } else {
            System.out.println("Linked lists do not intersect!");
        }
    }
     
    // Definition of linked list node
    class Node {
 
        private int data;
        private Node next;
 
        public Node(int data) {
            this.data = data;       
        }
 
        public int getData() {
            return data;
        }
 
        public void setData(int data) {
            this.data = data;
        }
 
        public Node getNext() {
            return next;
        }
 
        public void setNext(Node next) {
            this.next = next;
        }   
    }
}
 