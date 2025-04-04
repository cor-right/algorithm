package _2025.subjects._8_tree_dfs;

/**
 * 验证二叉搜索树
 *
 * @author 佳叙
 * @date 2025/4/4
 * @description <a href="https://leetcode.cn/problems/validate-binary-search-tree/"/>
 */
public class _98_validate_binary_search_tree {

    /**
     * 1. 二叉搜索树的中序遍历，是一个升序序列，所以可以用中序遍历，判断相邻元素之间的大小关系.
     * 2. 也可以使用递归，这里使用递归的时候有种二分的感觉在
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recursion(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean recursion(TreeNode node, long left, long right) {
        if (node == null) {
            return true;
        }

        if (node.val <= left || node.val >= right) {
            return false;
        }

        return recursion(node.left, left, node.val) && recursion(node.right, node.val, right);
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