// non-recursive java program for inorder traversal
 
/* importing the necessary class */
import java.util.Stack;
 
/* Class containing left and right child of current 
 node and key value*/
class TreeNode1 {
 
    int data;
    TreeNode1 left, right;
 
    public TreeNode1(int item) {
        data = item;
        left = right = null;
    }
}
 
/* Class to print the inorder traversal */
class TreeMaster {
 
    TreeNode1 root;
 
    void inorderIterativeStack() {
        if (root == null) {
            return;
        }
        
        //keep the nodes in the path that are waiting to be visited
        Stack<TreeNode1> stack = new Stack<TreeNode1>();
        TreeNode1 node = root;
         
        //first node to be visited will be the left one
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
         
        // traverse the tree
        while (stack.size() > 0) {
           
            // visit the top node
            node = stack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                node = node.right;
                 
                // the next node to be visited is the leftmost
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }
    
    public void inOrderRec(TreeNode1 root) {  
    	  if(root !=  null) {  
    	   inOrderRec(root.left);  
    	   //Visit the node by Printing the node data    
    	   System.out.printf("%d ",root.data);  
    	   inOrderRec(root.right);  
    	  }  
    	 }  
    
    void InorderIter(TreeNode1 root) {
    	TreeNode1 current, pre;
          
        if (root == null)
            return;
          
        current = root;
        while (current != null) 
        {
            if (current.left == null) 
            {
                System.out.print(current.data + " ");
                current = current.right;
            }
            else
            {
                /* Find the inorder predecessor of current */
                pre = current.left;
                while (pre.right != null && pre.right != current) 
                    pre = pre.right;
                 
                /* Make current as right child of its inorder predecessor */
                if (pre.right == null) 
                {
                    pre.right = current;
                    current = current.left;
                } 
  
                 /* Revert the changes made in if part to restore the 
                    original tree i.e.,fix the right child of predecssor*/
                 else
                 {
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }   /* End of if condition pre->right == NULL */
                  
            } /* End of if condition current->left == NULL*/
              
        } 
    }

    public void postorderIter( TreeNode1 root) {  
     if( root == null ) return;  
    
     Stack<TreeNode1> s = new Stack<TreeNode1>( );  
     TreeNode1 current = root;  
    
     while( true ) {  
    
         if( current != null ) {  
             if( current.right != null )   
              s.push( current.right );  
             s.push( current );  
             current = current.left;  
             continue;  
       }  
    
         if( s.isEmpty( ) )   
          return;  
         current = s.pop( );  
    
         if( current.right != null && ! s.isEmpty( ) && current.right == s.peek( ) ) {  
             s.pop( );  
             s.push( current );  
             current = current.right;  
         } else {  
             System.out.print( current.data + " " );  
             current = null;  
         }  
     }  
 }  
   /*
    * 1. Push root to first stack.
2. Loop while first stack is not empty
   2.1 Pop a node from first stack and push it to second stack
   2.2 Push left and right children of the popped node to first stack
3. Print contents of second stack

 void postOrderIterative2Stack(struct Node* root)
    {
        if (root == NULL) 
            return;
     
        // Create two stacks
        struct Stack* s1 = createStack(MAX_SIZE);
        struct Stack* s2 = createStack(MAX_SIZE);
     
        // push root to first stack
        push(s1, root);
        struct Node* node;
     
        // Run while first stack is not empty
        while (!isEmpty(s1))
        {
            // Pop an item from s1 and push it to s2
            node = pop(s1);
            push(s2, node);
     
            // Push left and right children of removed item to s1
            if (node->left)
                push(s1, node->left);
            if (node->right)
                push(s1, node->right);
        }
     
        // Print all elements of second stack
        while (!isEmpty(s2))
        {
            node = pop(s2);
            printf("%d ", node->data);
        }
    }*/
    
    public void preorderIter(TreeNode1 root) {  
        
        if(root == null)  
            return;  
   
        Stack<TreeNode1> stack = new Stack<TreeNode1>();  
        stack.push(root);  
   
        while(!stack.empty()){  
           
            TreeNode1 n = stack.pop();  
            System.out.printf("%d ",n.data);  
   
            
            if(n.right != null){  
                stack.push(n.right);  
            }  
            if(n.left != null){  
                stack.push(n.left);  
            }  
   
        }  
          
    }  


    public static void main(String args[]) {
         
        /* creating a binary tree and entering 
         the nodes */
        TreeMaster tree = new TreeMaster();
        tree.root = new TreeNode1(1);
        tree.root.left = new TreeNode1(2);
        tree.root.right = new TreeNode1(3);
        tree.root.left.left = new TreeNode1(4);
        tree.root.left.right = new TreeNode1(5);
        tree.inorderIterativeStack();
    }
}