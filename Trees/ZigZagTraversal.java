package Trees;
import java.util.*;
public class ZigZagTraversal {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (leftToRight) {
                    currentLevel.add(currentNode.val);
                } else {
                    currentLevel.add(0, currentNode.val);
                }
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add(currentLevel);
            leftToRight = !leftToRight;
        }
        return result;
    }
    public static void main(String[] args) {
        ZigZagTraversal zigzag = new ZigZagTraversal();
        TreeNode root = zigzag.new TreeNode(1);
        root.left = zigzag.new TreeNode(2);
        root.right = zigzag.new TreeNode(3);
        root.left.left = zigzag.new TreeNode(4);
        root.left.right = zigzag.new TreeNode(5);
        root.right.right = zigzag.new TreeNode(6);
        List<List<Integer>> levels = zigzag.zigzagLevelOrder(root);
        for (List<Integer> level : levels) {
            System.out.println(level);
        }
    }
}
