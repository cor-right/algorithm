package _2025._hot100._20250330;

/**
 * 二叉树的最近公共祖先
 *
 * @author 佳叙
 * @date 2025/3/30
 * @description <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/"/>
 */
public class _236_lowest_common_ancestor_of_a_binary_tree {

    /**
     * 1. 可以用递归，判断左右子树和自身同时包含 p、q.
     * 2. 可以记录路径，判断路径的交叉点.
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = new TreeNode(Integer.MIN_VALUE);
        recursion(root, ancestor, p, q);
        return ancestor;
    }

    private int recursion(TreeNode node, TreeNode ancestor, TreeNode p, TreeNode q) {
        if (node == null) {
            return 0;
        }

        int left  = recursion(node.left,  ancestor, p, q);
        int right = recursion(node.right, ancestor, p, q);

        if (ancestor.val != Integer.MIN_VALUE) {
            return 0;
        }

        int score = left + right + ((node.val == p.val || node.val == q.val) ? 1 : 0);
        if (score == 2) {
            ancestor.val = node.val;
            ancestor.left = node.left;
            ancestor.right = node.right;
        }

        return score;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}