package _2025._hot100._20250323;

import java.util.Stack;

/**
 * 验证二叉树
 *
 * @author 佳叙
 * @date 2025/3/23
 * @description <a href="https://leetcode.cn/problems/validate-binary-search-tree/description/"/>
 */
public class _98_validate_binary_search_tree {

    /**
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     * - 思路：中序遍历，记录前驱数据，判断前驱数据必须比当前数据小。
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        long last = Long.MIN_VALUE;
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            if (current.val <= last) {
                return false;
            }

            last = current.val;
            current = current.right;
        }

        return true;
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