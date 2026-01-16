package Trees;

public class MaxPathSumInBT {
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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMaxPath(root);
        return maxSum;
    }
    public int findMaxPath(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = Math.max(findMaxPath(root.left),0);
        int right = Math.max(findMaxPath(root.right),0);
        int currentPathSum = root.val + left + right;
        maxSum = Math.max(maxSum,currentPathSum);
        return root.val + Math.max(left,right);
    }
    public static void main(String[] args) {
        MaxPathSumInBT MaxPathSum = new MaxPathSumInBT();
        TreeNode root = MaxPathSum.new TreeNode(-10);
        root.left = MaxPathSum.new TreeNode(9);
        root.right = MaxPathSum.new TreeNode(20);
        root.right.left = MaxPathSum.new TreeNode(15);
        root.right.right = MaxPathSum.new TreeNode(7);
        int maxPathSum = MaxPathSum.maxPathSum(root);
        System.out.println("Max Path Sum in the Binary Tree: " + maxPathSum);
    }
}
