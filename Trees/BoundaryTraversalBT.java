package Trees;
import java.util.*;
public class BoundaryTraversalBT {
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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        result.add(root.val);
        addLeftBoundary(root.left,result);
        addLeaves(root.left,result);
        addLeaves(root.right,result);
        addRightBoundary(root.right,result);
        return result;
    }
    public void addLeftBoundary(TreeNode root,List<Integer> result){
        TreeNode curr = root;
        while(curr!=null){
            if(!isLeaf(curr)){
                result.add(curr.val);
            }
            if(curr.left!=null){
                curr=curr.left;
            }else{
                curr=curr.right;
            }
        }
    }
    public void addRightBoundary(TreeNode root,List<Integer> result){
        TreeNode curr = root;
        List<Integer> temp = new ArrayList<>();
        while(curr!=null){
            if(!isLeaf(curr)){
                temp.add(curr.val);
            }
            if(curr.right!=null){
                curr=curr.right;
            }else{
                curr=curr.left;
            }
        }
        for(int i=temp.size()-1;i>=0;i--){
            result.add(temp.get(i));
        }
    }
    public void addLeaves(TreeNode root,List<Integer> result){
        if(isLeaf(root)){
            result.add(root.val);
            return;
        }
        if(root.left!=null){
            addLeaves(root.left,result);
        }
        if(root.right!=null){
            addLeaves(root.right,result);
        }
    }
    public boolean isLeaf(TreeNode node){
        return node.left==null && node.right==null;
    }
    public static void main(String[] args) {
        BoundaryTraversalBT bt = new BoundaryTraversalBT();
        TreeNode root = bt.new TreeNode(1);
        root.left = bt.new TreeNode(2);
        root.right = bt.new TreeNode(3);
        root.left.left = bt.new TreeNode(4);
        root.left.right = bt.new TreeNode(5);
        root.right.right = bt.new TreeNode(6);
        List<Integer> boundary = bt.boundaryOfBinaryTree(root);
        System.out.println("Boundary Traversal of the Binary Tree: " + boundary);

    }
}
