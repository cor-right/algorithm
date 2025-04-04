package _2025.subjects._8_tree_dfs;

/**
 * 二叉树的直径
 *
 * <p>
 *     Recursion template.
 *     1. Do something.
 *     2. Recurse for sub problems.
 * </p>
 *
 * <p>
 *     Two type recursion.
 *     1. Top Down DFS
 *     2. Bottom Up DFS (More common)
 * </p>
 *
 * <p>
 *     Bottom Up DFS template.
 *     1. Bad Case
 *     2. Get sub problems return
 *     3. Builder return
 *     4. Do something if necessary
 *     5. Return
 * </p>
 *
 * @author 佳叙
 * @date 2025/4/4
 * @description <a href="https://leetcode.cn/problems/diameter-of-binary-tree/"/>
 */
public class _543_diameter_of_binary_tree {

    private int max = 0;

    /**
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        recursion(root);
        return max;
    }

    private int recursion(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left  = recursion(node.left);
        int right = recursion(node.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
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