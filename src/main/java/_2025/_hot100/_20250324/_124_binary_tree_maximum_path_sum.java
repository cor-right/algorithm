package _2025._hot100._20250324;

/**
 * @author 佳叙
 * @date 2025/3/24
 * @description <a href="https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/"/>
 */
public class _124_binary_tree_maximum_path_sum {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // recursion
        recursion(root);
        return max;
    }

    private int recursion(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left  = recursion(node.left);
        int right = recursion(node.right);

        max = Math.max(node.val, max);
        max = Math.max(node.val + left, max);
        max = Math.max(node.val + right, max);
        max = Math.max(node.val + left + right, max);

        return node.val + Math.max(Math.max(left, right), 0);
    }

    private class TreeNode {
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

}