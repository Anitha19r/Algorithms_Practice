public class CheckIfSymmetricBinaryTree 
{
    class TreeNode
    {
        TreeNode left;
        TreeNode right;
        int value;
     
        public TreeNode(int value)
        {
            this.value = value;
        }
    }
     
    TreeNode root;
 
     
    /*
                            0
                      1             1
                  3      4       4     3
                    5                 5
                       
    */
    private TreeNode createTree()
    {
        this.root = new TreeNode(0);
        TreeNode n10   = new TreeNode(1);
        TreeNode n11   = new TreeNode(1);
        TreeNode n30   = new TreeNode(3);
        TreeNode n31   = new TreeNode(3);
        TreeNode n40   = new TreeNode(4);
        TreeNode n41   = new TreeNode(4);
        TreeNode n50   = new TreeNode(5);
        TreeNode n51   = new TreeNode(5);
         
        root.left  = n10;
        root.right = n11;
         
        n10.left  = n30;
        n10.right = n40;
         
        n11.right = n31;
        n11.left  = n41;
 
        n30.left = n50;
        n31.right = n51;
         
        return root;
    }
 
 
    private boolean isSymmetric(TreeNode root1, TreeNode root2)
    {
        if (root1 == null && root2 == null)
        {
            return true;
        }
        else if (root1 == null || root2 == null)
        {
            return false;
        }
         
        if (root1.value == root2.value)
        {
            if (isSymmetric(root1.left, root2.right))
            {
                return isSymmetric(root1.right, root2.left);
            }
        }
        return false;
    }
 
 
    public boolean isSymmetric(TreeNode root)
    {
        return isSymmetric(root, root);
    }
     
     
    public static void main(String[] args)
    {
        CheckIfSymmetricBinaryTree tree = new CheckIfSymmetricBinaryTree();
 
        /*
                                0
                          1             1
                      3      4       4     3
                        5                 5
                           
        */
        tree.createTree();
 
        System.out.println("tree is symmetric: "+tree.isSymmetric(tree.root));
    }
}