package _2025.subjects._8_tree_dfs;

/**
 * 平衡二叉树
 *
 * @author 佳叙
 * @date 2025/4/5
 * @description <a href="https://leetcode.cn/problems/balanced-binary-tree/description/"/>
 */
public class _110_balanced_binary_tree {

    private boolean balanced = true;

    /**
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        recursion(root);
        return balanced;
    }

    private int recursion(TreeNode node) {
        if (node == null || !balanced) {
            return 0;
        }

        int left  = recursion(node.left);
        int right = recursion(node.right);

        if (Math.abs(right - left) > 1) {
            balanced = false;
        }

        return Math.max(left, right) + 1;
    }

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

}