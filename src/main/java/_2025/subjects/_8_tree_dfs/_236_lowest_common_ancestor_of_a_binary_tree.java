package _2025.subjects._8_tree_dfs;

/**
 * 二叉树的最近公共祖先
 *
 * @author 佳叙
 * @date 2025/4/5
 * @description <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/"/>
 */
public class _236_lowest_common_ancestor_of_a_binary_tree {

    private TreeNode ancestor = null;

    /**
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recursion(root, p, q);
        return ancestor;
    }

    /**
     * 确定找到公共祖先的时机
     *
     * @param node
     * @param p
     * @param q
     * @return
     */
    private int recursion(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || ancestor != null) {
            return 0;
        }

        int left  = recursion(node.left,  p, q);
        int right = recursion(node.right, p, q);
        int self  = (node == p || node == q) ? 1 : 0;

        int sum = left + right + self;
        if (sum == 2 && ancestor == null) {
            ancestor = node;
        }

        return sum;
    }



    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}