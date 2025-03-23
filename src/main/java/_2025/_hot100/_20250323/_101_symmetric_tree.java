package _2025._hot100._20250323;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树
 *
 * @author 佳叙
 * @date 2025/3/23
 * @description <a href="https://leetcode.cn/problems/symmetric-tree/description/"/>
 */
public class _101_symmetric_tree {

    /**
     * 递归是最简单的，用队列可以实现迭代。
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return iterate(root);
//        return recursion(root.left, root.right);
    }

    private boolean iterate(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode left  = queue.poll();
            TreeNode right = queue.poll();

            if (left == null || right == null) {
                if (left == null && right == null) {
                    continue;
                }
                else {
                    return false;
                }
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

    private boolean recursion(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == null && right == null;
        }
        if (left.val != right.val) {
            return false;
        }

        return recursion(left.left, right.right) && recursion(left.right, right.left);
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