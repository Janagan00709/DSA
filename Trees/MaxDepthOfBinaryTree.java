package Trees;

public class MaxDepthOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftDepth = 1 + maxDepth(root.left);
        int rightDepth = 1 + maxDepth(root.right);
        return Math.max(leftDepth,rightDepth);
    }
    public static void main(String[] args) {
        MaxDepthOfBinaryTree MaxDepth = new MaxDepthOfBinaryTree();
        TreeNode root = MaxDepth.new TreeNode(1);
        root.left = MaxDepth.new TreeNode(2);
        root.right = MaxDepth.new TreeNode(3);
        root.left.left = MaxDepth.new TreeNode(4);
        root.left.right = MaxDepth.new TreeNode(5);
        root.right.right = MaxDepth.new TreeNode(6);
        int depth = MaxDepth.maxDepth(root);
        System.out.println("Max Depth of the Binary Tree: " + depth);
    }
}
