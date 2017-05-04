import java.util.Queue;
import java.util.LinkedList;
 
/* Class to represent Tree node */
class Node {
    int data;
    Node left, right;
 
    public Node(int item) {
        data = item;
        left = null;
        right = null;
    }
}
 
/* Class to print Level Order Traversal */
class LevelOrderTraversalQue {
 
    Node root;
 
    /* Given a binary tree. Print its nodes in level order
     using array for implementing queue  */
    void printLevelOrder() 
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        int count=0,count1=0;
        while (!queue.isEmpty()) 
        {
        	count1++;
        	count = queue.size();
        	while(count >0)
        	{
 
            /* poll() removes the present head.
            For more information on poll() visit 
            http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
 
            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
 
            /*Enqueue right child */
            if (tempNode.right != null) 
            {
                queue.add(tempNode.right);
            }
            count--;
        	}
        	System.out.println("");
        }
        System.out.println(count1);
    }
   
    public static void main(String args[]) 
    {
        /* creating a binary tree and entering 
         the nodes */
        LevelOrderTraversalQue tree_level = new LevelOrderTraversalQue();
        tree_level.root = new Node(1);
        tree_level.root.left = new Node(2);
        tree_level.root.right = new Node(3);
        tree_level.root.left.left = new Node(4);
        tree_level.root.left.right = new Node(5);
        tree_level.root.right.left = new Node(4);
        tree_level.root.right.right = new Node(5);
        tree_level.root.right.right.right = new Node(8);
 
        System.out.println("Level order traversal of binary tree is - ");
        tree_level.printLevelOrder();
    }
}