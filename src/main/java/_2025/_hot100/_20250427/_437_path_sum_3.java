package _2025._hot100._20250427;

import java.util.*;

/**
 * 路径总和 Ⅲ
 *
 * @author 佳叙
 * @date 2025/4/27
 * @description <a href=""/>
 */
public class _437_path_sum_3 {

    /**
     * 二叉树的前序遍历（根、左、右）
     *
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        // 前缀和
        Map<Long, Integer> memo = new HashMap();
        memo.put(0L, 1);

        return recursion(root, memo, 0L, targetSum);
    }

    private int recursion(TreeNode node, Map<Long, Integer> memo, long prefix, long targetSum) {
        if (node == null) {
            return 0;
        }

        // Use prefix. 这里 prefix - targetSum 是重点，这样就将查找到范围变成从根节点开始的前缀和了，而不是从当前节点开始的前缀和。
        prefix += node.val;
        int num = memo.getOrDefault(prefix - targetSum, 0);

        // Add prefix.
        memo.put(prefix, memo.getOrDefault(prefix, 0) + 1);

        // Recursion.
        num += recursion(node.left, memo, prefix, targetSum);
        num += recursion(node.right, memo, prefix, targetSum);

        // Remove prefix.
        memo.put(prefix, memo.get(prefix) - 1);

        // Return.
        return num;
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