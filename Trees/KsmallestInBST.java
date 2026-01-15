package Trees;

public class KsmallestInBST {
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
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = -1;
        inorder(root,k);
        return result;
    }
    public void inorder(TreeNode root,int k){
        if(root==null){
            return;
        }
        inorder(root.left,k);
        count++;
        if(count==k){
            result = root.val;
            return;
        }
        inorder(root.right,k);
    }
    public static void main(String[] args) {
        KsmallestInBST Ksmallest = new KsmallestInBST();
        TreeNode root = Ksmallest.new TreeNode(3);
        root.left = Ksmallest.new TreeNode(1);
        root.right = Ksmallest.new TreeNode(4);
        root.left.right = Ksmallest.new TreeNode(2);
        int k = 3;
        int kthSmallest = Ksmallest.kthSmallest(root, k);
        System.out.println(k + "th smallest element in the BST: " + kthSmallest);
    }
}
