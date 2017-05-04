
	// Java program for recursive level order traversal in spiral form
	  
	/* A binary tree node has data, pointer to left child 
	   and a pointer to right child */
	class NodeLO 
	{
	    int data;
	    NodeLO left, right;
	  
	    public NodeLO(int d) 
	    {
	        data = d;
	        left = right = null;
	    }
	}
	  
	class LevelOrderSpiralRecurssive 
	{
	    NodeLO root;
	  
	    // Function to print the spiral traversal of tree
	    void printSpiral(NodeLO node) 
	    {
	        int h = height(node);
	        int i;
	  
	        /* ltr -> left to right. If this variable is set then the
	           given label is transversed from left to right */
	        boolean ltr = false;
	        for (i = 1; i <= h; i++) 
	        {
	            printGivenLevel(node, i, ltr);
	  
	            /*Revert ltr to traverse next level in opposite order*/
	            ltr = !ltr;
	        }
	  
	    }
	  
	    /* Compute the "height" of a tree -- the number of
	    nodes along the longest path from the root node
	    down to the farthest leaf node.*/
	    int height(NodeLO node) 
	    {
	        if (node == null) 
	            return 0;
	        else
	        {
	              
	            /* compute the height of each subtree */
	            int lheight = height(node.left);
	            int rheight = height(node.right);
	  
	            /* use the larger one */
	            if (lheight > rheight) 
	                return (lheight + 1);
	            else
	                return (rheight + 1);
	        }
	    }
	  
	    /* Print nodes at a given level */
	    void printGivenLevel(NodeLO node, int level, boolean ltr) 
	    {
	        if (node == null) 
	            return;
	        if (level == 1) 
	            System.out.print(node.data + " ");
	        else if (level > 1) 
	        {
	            if (ltr != false) 
	            {
	                printGivenLevel(node.left, level - 1, ltr);
	                printGivenLevel(node.right, level - 1, ltr);
	            } 
	            else
	            {
	                printGivenLevel(node.right, level - 1, ltr);
	                printGivenLevel(node.left, level - 1, ltr);
	            }
	        }
	    }
	    /* Driver program to test the above functions */
	    public static void main(String[] args) 
	    {
	    	LevelOrderSpiralRecurssive tree = new LevelOrderSpiralRecurssive();
	        tree.root = new NodeLO(1);
	        tree.root.left = new NodeLO(2);
	        tree.root.right = new NodeLO(3);
	        tree.root.left.left = new NodeLO(7);
	        tree.root.left.right = new NodeLO(6);
	        tree.root.right.left = new NodeLO(5);
	        tree.root.right.right = new NodeLO(4);
	        System.out.println("Spiral order traversal of Binary Tree is ");
	        tree.printSpiral(tree.root);
	    }
	}
	
	/*iterative
	 * 
	 * 
	 * void printSpiral(NodeLO node) 
    {
        if (node == null) 
            return;   // NULL check
 
        // Create two stacks to store alternate levels
        Stack<NodeLO> s1 = new Stack<NodeLO>();// For levels to be printed from right to left
        Stack<NodeLO> s2 = new Stack<NodeLO>();// For levels to be printed from left to right
 
        // Push first level to first stack 's1'
        s1.push(node);
 
        // Keep ptinting while any of the stacks has some nodes
        while (!s1.empty() || !s2.empty()) 
        {
            // Print nodes of current level from s1 and push nodes of
            // next level to s2
            while (!s1.empty()) 
            {
                NodeLO temp = s1.peek();
                s1.pop();
                System.out.print(temp.data + " ");
 
                // Note that is right is pushed before left
                if (temp.right != null) 
                    s2.push(temp.right);
                 
                if (temp.left != null) 
                    s2.push(temp.left);
                 
            }
 
            // Print nodes of current level from s2 and push nodes of
            // next level to s1
            while (!s2.empty()) 
            {
                NodeLO temp = s2.peek();
                s2.pop();
                System.out.print(temp.data + " ");
 
                // Note that is left is pushed before right
                if (temp.left != null)
                    s1.push(temp.left);
                if (temp.right != null)
                    s1.push(temp.right);
            }
        }*/
