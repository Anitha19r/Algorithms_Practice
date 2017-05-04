import java.util.Stack;


public class LinkedListMaster{

 private static Node head;
 private static Node left;

 private static class Node {
  private int value;
  private Node next;
  
  Node() {
	   

	  }
  Node(int value) {
   this.value = value;

  }
 }
 private static class PartialSum{
	 Node sum;
	 int carry;
 }

 public void addToTheLast(Node node) {

  if (head == null) {
   head = node;
  } else {
   Node temp = head;
   while (temp.next != null)
    temp = temp.next;

   temp.next = node;
  }
 }


 public void printList() {
  Node temp = head;
  while (temp != null) {
   System.out.format("%d ", temp.value);
   temp = temp.next;
  }
  System.out.println();
 }

 
 //Loop
 
 public boolean ifLoopExists() {
	  Node fastPtr = head;
	  Node slowPtr = head;
	  while (fastPtr != null && fastPtr.next != null) {
	   fastPtr = fastPtr.next.next;
	   slowPtr = slowPtr.next;
	   if (slowPtr == fastPtr)
	    return true;

	  }
	  return false;
	  //This is for start of loop
	  /*if(loopExists)
	  {
	   slowPtr=head;

	   while(slowPtr!=fastPtr)
	   {
	   	
	    slowPtr=slowPtr.next;
	    fastPtr=fastPtr.next;
	   }

	   
	  }
	  else
	  {
	   System.out.println("Loop does not exists");
	   slowPtr=null;
	  }
	  return slowPtr;
	 }*/

	 }
// This function will find middle element in linkedlist
 public Node findMiddleNode(Node head)
 {
	 Node slowPtr=head, fastPtr=head ;
	 while(fastPtr!=null){
		 fastPtr=fastPtr.next;
		 if(fastPtr!=null && fastPtr.next!=null){
			 slowPtr=slowPtr.next;
			 fastPtr=fastPtr.next;
		 }
	 }
	 return slowPtr;

 }
 public static Node getMiddle(Node first) { 
	 Node slowPointer, fastPointer, prevPtr; 
	 slowPointer = fastPointer = prevPtr=first; 
	 while(fastPointer !=null) { 
	 fastPointer = fastPointer.next; 
	 if(fastPointer != null && fastPointer.next != null) { 
	 prevPtr = slowPointer;	 
	 slowPointer = slowPointer.next; 
	 fastPointer = fastPointer.next; 
	 } 
	 } 

	 return prevPtr; 
	 } 
 public static Node  reverseLL(Node curr){
	 Node prev, next;
	 prev =null;
	 while (curr!=null)
	 {
		 next=curr.next;
		 curr.next=prev;
		 prev=curr;
		 curr=next;
	 }
	 return prev;
 }
 public static Node reverseLinkedListRec(Node node) {  
     if (node == null || node.next == null) {  
         return node;  
     }  
  
     Node remaining = reverseLinkedListRec(node.next);  
     node.next.next = node;  
     node.next = null;  
    return remaining;  
 }  
 

 public static Node reverseHalf(Node first){
	 Node h=first;
	 Node mid =getMiddle(h);
	 Node revHead = reverseLL(mid.next);
	 mid.next=revHead;
	 return revHead;
 }
	 
 public static Node revHalfStack(Node first){
	 //Node h=first;
	 Node prev =getMiddle(first);
	 Node mid =prev.next;
	 Stack<Node> st = new Stack<Node>();
	 while(mid!=null){
		 st.push(mid);
		 mid=mid.next;
		 
	 }
	 while(!st.isEmpty()){
		 prev.next=st.pop();
		 prev=prev.next;
	 }
	 prev.next=null;
	 return first;
 }
 public static boolean palindrome(Node first){
	Node h=first;
	 Node prev =getMiddle(first);
	 Node mid =prev.next;
	 prev.next=null;
	 /*either use stack or use two ptrs one from head and one from mid.next and check for iteration for inplace*/
	 Stack<Node> st = new Stack<Node>();
	 while(mid!=null){
		 st.push(mid);
		 mid=mid.next;
		 
	 }
	 while(!st.isEmpty() && h!=null){
		 if(h.value!=st.pop().value)
			 return false;
		 h=h.next;
	 }
	 return true;
 }
 
 public static boolean palindromeRec(Node right) 
 {
     left = head;
      
     /* stop recursion when right becomes NULL */
     if (right == null)
         return true;

     /* If sub-list is not palindrome then no need to
        check for current left and right, return false */
     boolean isp = palindromeRec(right.next);
     if (isp == false)
         return false;

     /* Check values at current left and right */
     boolean isp1 = (right.value == (left).value);

     /* Move left to next node */
     left = left.next;

     return isp1;
 }

 // A wrapper over isPalindromeUtil()
 public static boolean isPalindrome(Node head) 
 {
     boolean result = palindromeRec(head);
     return result;
 }
 
 //palindrome rec ends
 public static Node reversePairsIt(Node head) {
	  
	  Node current=head;
	  Node temp=null;
	  Node newHead =null;
	     while (current != null && current.next != null) {
	    
	      if (temp != null) {
	     // This is important step
	             temp.next.next = current.next;
	         }
	       temp=current.next;     
	       current.next=temp.next;
	       temp.next=current;
	      
	       if (newHead == null)
	                 newHead = temp;
	       current=current.next;
	       
	    }     
	    return newHead;
	 }
 public static Node reversePairsRec(Node head) {
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
    head.next=reversePairsRec(head.next);
 // returning new head
    return temp;
 }
 
 public static Node reverseWindow(Node head, int k)
 {
    Node current = head;
    Node next = null;
    Node prev = null;
     
    int count = 0;

    /* Reverse first k nodes of linked list */
    while (count < k && current != null) 
    {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
        count++;
    }

    /* next is now a pointer to (k+1)th node 
       Recursively call for the list starting from current.
       And make rest of the list as next of first node */
    if (next != null) 
       head.next = reverseWindow(next, k);

    // prev is now head of input list
    return prev;
 }     
 
 Node kAltReverse(Node node, int k) {
     Node current = node;
     Node next = null, prev = null;
     int count = 0;

     /*1) reverse first k nodes of the linked list */
     while (current != null && count < k) {
         next = current.next;
         current.next = prev;
         prev = current;
         current = next;
         count++;
     }

     /* 2) Now head points to the kth node.  So change next 
      of head to (k+1)th node*/
     if (node != null) {
         node.next = current;
     }

     /* 3) We do not want to reverse next k nodes. So move the current 
      pointer to skip next k nodes */
     count = 0;
     while (count < k - 1 && current != null) {
         current = current.next;
         count++;
     }

     /* 4) Recursively call for the list starting from current->next.
      And make rest of the list as next of first node */
     if (current != null) {
         current.next = kAltReverse(current.next, k);
     }

     /* 5) prev is new head of the input list */
     return prev;
 }
 /*,merge  sort a LL*/
public Node merge_sort(Node head) {
    if(head == null || head.next == null) { return head; }
    Node middle = getMiddle(head);      //get the middle of the list
    Node sHalf = middle.next; 
    middle.next = null;   //split the list into two halfs

    return merge(merge_sort(head),merge_sort(sHalf));  //recurse on that
}

//Merge subroutine to merge two sorted lists
public Node merge(Node a, Node b) {
    Node dummyHead, curr; dummyHead = new Node(); curr = dummyHead;
    while(a !=null && b!= null) {
        if(a.value <= b.value) { curr.next = a; a = a.next; }
        else { curr.next = b; b = b.next; }
        curr = curr.next;
    }
    curr.next = (a == null) ? b : a;
    return dummyHead.next;
}
  
 /*,merge  sort a LL end */


//addTwoListsReverse


static Node addTwoListsFront(Node l1, Node l2, int carry){
	if(l1==null && l2==null && carry==0) return null;
	Node result = new Node();
	int val = carry;
	if(l1!=null) val+=l1.value;
	if(l2!=null) val+=l2.value;
	result.value = val %10;
	carry = val/10;
	if(l1!=null || l2!=null)
		result.next = addTwoListsFront(l1.next,l2.next,carry);
	return result;
}
//Add from front of ll
static Node  addTwoListsFromEnd(Node l1, Node l2, int carry){
	int len1=length(l1);
	int len2=length(l2);
	l1=(len1<len2? padList(l1,len2-len1):l1);
	l2=(len2<len1? padList(l2,len1-len2):l2);
	PartialSum tempsum = addListHelper(l1,l2);
	if(tempsum.carry ==0){
		return tempsum.sum;
	}
	else {
		Node result =insertBefore(tempsum.sum,tempsum.carry);
		return result;
	}
}

private static PartialSum addListHelper(Node l1, Node l2) {
	if(l1==null && l2==null) return null;
	PartialSum temp = addListHelper(l1.next,l2.next);
	int val = temp.carry+l1.value+l2.value;
	Node full_result = insertBefore(temp.sum, val%10);
	temp.sum=full_result;
	temp.carry = val/10;
	return temp;
}
static Node  differenceTwoListsFromEnd(Node l1, Node l2, int carry){
	int len1=length(l1);
	int len2=length(l2);
	l1=(len1<len2? padList(l1,len2-len1):l1);
	l2=(len2<len1? padList(l2,len1-len2):l2);
	PartialSum tempsum = addListHelper(l1,l2);
	boolean borrow=false;
	return differenceListHelper(l1,l2,borrow);
}
private static Node differenceListHelper(Node l1, Node l2,boolean borrow) {
	if(l1==null && l2==null) return null;
	Node temp = differenceListHelper(l1.next,l2.next,borrow);
	int diff=0;
	int d1= l1.value;
	int d2=l2.value;
	if(borrow) {
		d1--; 
		borrow=false;
	}
	if(d1<d2){
		borrow=true;
		d1=d1+10;
	}
	diff=d1-d2;
	Node result = new Node(diff);
	return result;
}

private static Node padList(Node l1, int i) {
	// TODO Auto-generated method stub
	Node head=l1;
	for(int j =0; j<i;j++ ){
		head = insertBefore(head,0);
	}
	return head;
}


private static Node insertBefore(Node l1, int data) {
	// TODO Auto-generated method stub
	Node node1 = new Node();
	node1.value = data;
	if(l1!=null){
		node1.next=l1;
	}
	return node1;
}


public static int length(Node a){
	int size=0;
	while (a!=null){
		size++;
		a=a.next;
	}
	return size;
}
//Add from front of ll end

//print the LL
 public void printList(Node head) {  
	  Node temp = head;  
	  while (temp != null) {  
	   System.out.format("%d ", temp.value);  
	   temp = temp.next;  
	  }  
	  System.out.println();  
	 }  

 public static void main(String[] args) {
  LinkedListMaster list = new LinkedListMaster();
  LinkedListMaster list1 = new LinkedListMaster();
  // Creating a linked list
  Node head=new Node(5);
  list.addToTheLast(head);
  list.addToTheLast(new Node(6));
  list.addToTheLast(new Node(7));
  list.addToTheLast(new Node(1));
  list.addToTheLast(new Node(8));
  list.addToTheLast(new Node(6));
  list.addToTheLast(new Node(5));
  Node head1=new Node(5);
  list1.addToTheLast(head1);
  list1.addToTheLast(new Node(6));
  list1.addToTheLast(new Node(7));
  list1.addToTheLast(new Node(1));
  list1.addToTheLast(new Node(8));
  list1.addToTheLast(new Node(4));
  list1.addToTheLast(new Node(5));
  System.out.println("2 list:" );
  list.printList();
  list1.printList();
  /*Node merge = list1.merge_sort(head1);
  System.out.println("Sorted:" );
  list1.printList(merge);*/
 // System.out.println("Reverse recurr:" );
 // Node merge=reverseLinkedListRec(head1);
  
  
  Node merge=addTwoListsFront(head,head1,0);
  System.out.println("Sum recurr:" );
  list1.printList(merge);
  list1.printList(merge);
  list.printList();
  // finding middle elemennt
  Node middle= list.findMiddleNode(head);
  
  System.out.println("Middle node will be: "+ middle.value);
  middle=reverseHalf(head);
  list.printList();
  System.out.println("Middle node will be: "+ middle.value);
  middle=revHalfStack(head);
  list.printList();
  System.out.println(palindrome(head));
  list.printList();
  middle=reverseWindow(head,3);//comment the other bfr running one 
  list.printList(middle);
  middle=reversePairsIt(head);//comment the other bfr running one 
  list.printList(middle);
  middle =reversePairsRec(head);//always run alone
  list.printList(middle);
 }

}
