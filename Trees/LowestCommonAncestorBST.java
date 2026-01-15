package Trees;

public class LowestCommonAncestorBST {
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root.val>p.val && root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }else if(root.val<p.val && root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }else{
            return root;
        }
    }
    public static void main(String[] args) {
        LowestCommonAncestorBST LCA = new LowestCommonAncestorBST();
        TreeNode root = LCA.new TreeNode(6);
        root.left = LCA.new TreeNode(2);
        root.right = LCA.new TreeNode(8);
        root.left.left = LCA.new TreeNode(0);
        root.left.right = LCA.new TreeNode(4);
        root.left.right.left = LCA.new TreeNode(3);
        root.left.right.right = LCA.new TreeNode(5);
        root.right.left = LCA.new TreeNode(7);
        root.right.right = LCA.new TreeNode(9);
        TreeNode p = root.left; // Node with value 2
        TreeNode q = root.right; // Node with value 8
        TreeNode lca = LCA.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val);
    }
}
