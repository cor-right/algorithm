package _2025._hot100._20250323;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 二叉树的层次遍历
 *
 * @author 佳叙
 * @date 2025/3/23
 * @description <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/description/"/>
 */
public class _102_binary_tree_level_order_traversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<TreeNode> nodes = new ArrayList<>();
            while (!queue.isEmpty()) {
                nodes.add(queue.poll());
            }

            result.add(nodes.stream().map(node -> node.val).collect(Collectors.toList()));
            queue.addAll(nodes.stream().map(node -> Arrays.asList(node.left, node.right)).flatMap(List::stream).filter(Objects::nonNull).collect(Collectors.toList()));
        }

        return result;
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