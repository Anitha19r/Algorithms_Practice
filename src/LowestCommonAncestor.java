public class LowestCommonAncestor {
 

private TreeNode root;
     
    public TreeNode getRoot() {
        return root;
    }
 
    public TreeNode getLowestCommonAncestor(TreeNode A, TreeNode B) {       
        return getLowestCommonAncestor(root, A, B); 
    }
 
    private TreeNode getLowestCommonAncestor(TreeNode curr, TreeNode A, TreeNode B) {
         
        if(curr == null) {
            return null;
        }
         
        // If we find p or q, we return the node
        if(curr == A || curr == B)
            return curr;
         
        // Recursive calls to find LCA in left and right subtrees
        TreeNode leftNode = getLowestCommonAncestor(curr.getLeft(), A, B);
        TreeNode rightNode = getLowestCommonAncestor(curr.getRight(), A, B);
         
        // If we found p and q in left or right subtree of the current node, 
        // this means current node is a common ancestor, so return the node
        if(leftNode != null && rightNode != null)
            return curr;
         
        // If we found p or q in left or right subtree of the current node,
        // the means current node is an ancestor, return the node
        if(leftNode == null) {
            return rightNode;
        } else {
            return leftNode;
        }
    }
     
    /**
     * Defines a tree node
     * @author Saurabh
     *
     */
    class TreeNode {
         
        private int data;
        private TreeNode left;
        private TreeNode right;
         
        public TreeNode(int data, TreeNode left, TreeNode right) {
            super();
            this.data = data;
            this.left = left;
            this.right = right;
        }
 
        public int getData() {
            return data;
        }
 
        public void setData(int data) {
            this.data = data;
        }
 
        public TreeNode getLeft() {
            return left;
        }
 
        public void setLeft(TreeNode left) {
            this.left = left;
        }
 
        public TreeNode getRight() {
            return right;
        }
 
        public void setRight(TreeNode right) {
            this.right = right;
        }
 
        public TreeNode() {
            super();
        }
 
        public TreeNode(int data) {
            super();
            this.data = data;
        }
         
        @Override
        public String toString() {
            return data+""; 
        }
    }
     
    /*
     * *******************************************
     * Methods for testing getLowestCommonAncestor
     * *******************************************
     */
    public static void main(String[] args) {
        LowestCommonAncestor tree = new LowestCommonAncestor();
        tree.createSampleTree();
        TreeNode A = tree.getRoot().getLeft().getLeft();   // Node 4
        TreeNode B = tree.getRoot().getRight();            // Node 3
        TreeNode lca = tree.getLowestCommonAncestor(A, B);
        System.out.println("LCA of " + A.getData() + " and " + B.getData() + " is " + lca);
    }
     
    /*
     * Create a sample tree
     *              1
     *      2               3
     * 4        5       6       7
     * 
     */
    public void createSampleTree() {
        root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));       
    }
 
    /*
     * Print inorder traversal
     */
    public void printInorder() {
        printInorder(root);
    }
     
    private void printInorder(TreeNode root) {
        if(root == null) {
            return;
        }
        printInorder(root.getLeft());
        System.out.print(root.getData() + " ");
        printInorder(root.getRight());
    }
}