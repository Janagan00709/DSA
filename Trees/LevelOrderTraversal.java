package Trees;
import java.util.*;
public class LevelOrderTraversal {
    class TreeNode {
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }
    public static void main(String[] args) {
        LevelOrderTraversal lot = new LevelOrderTraversal();
        TreeNode root = lot.new TreeNode(1);
        root.left = lot.new TreeNode(2);
        root.right = lot.new TreeNode(3);
        root.left.left = lot.new TreeNode(4);
        root.left.right = lot.new TreeNode(5);
        root.right.right = lot.new TreeNode(6);
        List<List<Integer>> levels = lot.levelOrder(root);
        for (List<Integer> level : levels) {
            System.out.println(level);
        }        
    }
}
