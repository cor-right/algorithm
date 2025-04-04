package _2025.subjects._7_tree_bfs;

import java.util.*;

/**
 * 对称二叉树
 *
 * @author 佳叙
 * @date 2025/4/4
 * @description <a href="https://leetcode.cn/problems/symmetric-tree/description/"/>
 */
public class _101_symmetric_tree {

    /**
     * 1. 可以用单向队列，按照对称的方式添加子节点
     * 2. 可以用双向队列，正常添加子节点，然后分别从首位两端取，可惜 Deque 的 offer 方法有 NPE
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode left  = queue.poll();
            TreeNode right = queue.poll();

            if (left == null || right == null) {
                if (left != null || right != null) {
                    return false;
                }
                continue;
            }

            if (left.val != right.val) {
                return false;
            }

            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
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