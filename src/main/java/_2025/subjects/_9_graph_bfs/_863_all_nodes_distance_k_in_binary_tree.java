package _2025.subjects._9_graph_bfs;

import java.util.*;

/**
 * 二叉树中所有距离为 K 的节点
 *
 * @author 佳叙
 * @date 2025/4/5
 * @description <a href="https://leetcode.cn/problems/all-nodes-distance-k-in-binary-tree/description/"/>
 */
public class _863_all_nodes_distance_k_in_binary_tree {

    /**
     *
     * @param root
     * @param target
     * @param k
     * @return
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Build graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();

            if (node.left != null) {
                nodeQueue.offer(node.left);
                graph.computeIfAbsent(node.val, t -> new HashSet<>()).add(node.left.val);
                graph.computeIfAbsent(node.left.val, t -> new HashSet<>()).add(node.val);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                graph.computeIfAbsent(node.val, t -> new HashSet<>()).add(node.right.val);
                graph.computeIfAbsent(node.right.val, t -> new HashSet<>()).add(node.val);
            }
        }

        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.offer(target.val);

        int round = 0;
        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();

            if (round == k) {
                return new ArrayList<>(bfsQueue);
            }

            for (int i = 0; i < size; i++) {
                int node = bfsQueue.poll();

                Set<Integer> nears = graph.getOrDefault(node, new HashSet<>());
                if (nears.isEmpty()) {
                    continue;
                }

                for (int near : nears) {
                    bfsQueue.offer(near);
                    graph.get(near).remove(node);
                }
            }

            round++;
        }

        return new ArrayList<>();
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}