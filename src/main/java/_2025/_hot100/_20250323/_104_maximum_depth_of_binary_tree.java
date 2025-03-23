package _2025._hot100._20250323;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 佳叙
 * @date 2025/3/23
 * @description <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/"/>
 */
public class _104_maximum_depth_of_binary_tree {

    public int maxDepth(TreeNode root) {
        return maximumDepthLevelSearch(root);
//        return maximumDepth(root, 0);
    }

    private int maximumDepthLevelSearch(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int maximumDepth = 0;
        while (!queue.isEmpty()) {
            maximumDepth++;

            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                queue.addAll(Stream.of(node.left, node.right).filter(Objects::nonNull).collect(Collectors.toList()));
            }
        }

        return maximumDepth;
    }

    private int maximumDepth(TreeNode node, int level) {
        if (node == null) {
            return level;
        }
        return Math.max(maximumDepth(node.left, level), maximumDepth(node.right, level)) + 1;
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