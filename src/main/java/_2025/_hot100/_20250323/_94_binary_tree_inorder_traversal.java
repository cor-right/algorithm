package _2025._hot100._20250323;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 *
 * @author 佳叙
 * @date 2025/3/23
 * @description <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/description/"/>
 */
public class _94_binary_tree_inorder_traversal {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> data = new ArrayList<>();
//        recursion(data, root);
//        return data;

        // iterate
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Go down left
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Middle
            current = stack.pop();
            result.add(current.val);

            // To right
            current = current.right;
        }

        return result;
    }


    private void recursion(List<Integer> data, TreeNode node) {
        if (node == null) {
            return ;
        }

        recursion(data, node.left);
        data.add(node.val);
        recursion(data, node.right);
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