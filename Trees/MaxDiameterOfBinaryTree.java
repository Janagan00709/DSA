package Trees;

public class MaxDiameterOfBinaryTree {
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
        int diameter;
        public int diameterOfBinaryTree(TreeNode root) {
            diameter = 0;
            height(root);
            return diameter;
        }
        public int height(TreeNode root){
            if(root==null){
                return 0;
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            diameter = Math.max(diameter,leftHeight+rightHeight);
            return 1 + Math.max(leftHeight,rightHeight);
        }
        public static void main(String[] args) {
            MaxDiameterOfBinaryTree MaxDiameter = new MaxDiameterOfBinaryTree();
            TreeNode root = MaxDiameter.new TreeNode(1);
            root.left = MaxDiameter.new TreeNode(2);
            root.right = MaxDiameter.new TreeNode(3);
            root.left.left = MaxDiameter.new TreeNode(4);
            root.left.right = MaxDiameter.new TreeNode(5);
            int diameter = MaxDiameter.diameterOfBinaryTree(root);
            System.out.println("Max Diameter of the Binary Tree: " + diameter);
        }
}
