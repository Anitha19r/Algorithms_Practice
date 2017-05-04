public class ReverseLinkedListRecurrsive {
     
    private Node head;
 
    public Node getHead() {
        return head;
    }
 
    public void setHead(Node head) {
        this.head = head;
    }
     
    public void ReverseLinkedListRecurrsive() {
        ReverseLinkedListRecurrsive(head);
    }
 /* 
  * Recursively swap/reverse in pairs
  * public static Node reverseLinkedListInPairs(Node head) {
    if (head == null || head.next == null) {
        return head;
    }
// Lets take example of 5->6->7
// Here head node is 5    
// Storing 6 in temp node, it will become our new head    
   Node temp=head.next;
// Putting link between 5->7   
   head.next=temp.next;
// putting link between 6->5
   temp.next=head;
// recursively calling the function for node 7
   head.next=reverseLinkedListInPairRec(head.next);
// returning new head
   return temp;
}
*/
    

    private void ReverseLinkedListRecurrsive(Node curr) {
 
        if (curr == null) {
            return;
        }
 
        if (curr.getNext() == null) {
            this.head = curr;
            return;
        }
 
        ReverseLinkedListRecurrsive(curr.getNext());
        curr.getNext().setNext(curr);
        curr.setNext(null);
    }
     
    /* 
     * ******************************************************
     * Following methods are for testing the solution
     * ******************************************************
     */
    public static void main(String[] args) {
         
        ReverseLinkedListRecurrsive list = new ReverseLinkedListRecurrsive();
        list.createTestList(5);
        list.printlist();
        list.ReverseLinkedListRecurrsive();
        list.printlist();
    }
 
    /*
     * Create a test list having n nodes from 1 to n 
     */
    public void createTestList(int n) {
         
        if(n < 1)
            return;
         
        int i = 1;
        Node temp = null;
        while(i <= n) {
            Node node = new Node(i);        
            if(head == null) {
                head = node;
                temp = head;
            } else {
                temp.setNext(node);
                temp = node;
            }
            i++;
        }
    }
     
    /*
     * Print the list
     */
    public void printlist() {
         
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.getData() + " -> ");
            temp = temp.getNext();
        }
        System.out.println("X");
    }
     
    /**
     * Defines a linked list node class
     * @author Saurabh
     *
     */
    class Node {
 
        private int data;
        private Node next;
 
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
 
        public Node(int data) {
            super();
            this.data = data;
        }
    }
}
