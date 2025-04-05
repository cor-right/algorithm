package _2025.subjects._9_graph_bfs;

import java.util.*;

/**
 * 最小高度树
 *
 * @author 佳叙
 * @date 2025/4/5
 * @description <a href="https://leetcode.cn/problems/minimum-height-trees/description/"/>
 */
public class _310_minimum_height_tree {

    /**
     * 图中心的节点，就是树高度最小的根节点
     * 为了获得中心，需要使用拓扑排序的思想，从入度入手，不断移除叶子节点（入度为1），直到剩余节点数量不超过两个（最终入度为1/0的节点数量不会超过两个）
     *
     *
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Arrays.asList(0);
        }

        Set<Integer> ansSet = new HashSet<>();
        // Compute in degree.
        Map<Integer, Integer> degreeMap = new HashMap<>();
        Map<Integer, Set<Integer>> dependencies = new HashMap<>();

        for (int[] edge : edges) {
            ansSet.add(edge[0]);
            ansSet.add(edge[1]);
            degreeMap.put(edge[0], degreeMap.getOrDefault(edge[0], 0) + 1);
            degreeMap.put(edge[1], degreeMap.getOrDefault(edge[1], 0) + 1);
            dependencies.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            dependencies.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }

        // Init.
        Queue<Integer> queue = new LinkedList<>();
        for (int node : degreeMap.keySet()) {
            if (degreeMap.get(node) == 1) {
                queue.offer(node);
            }
        }

        // BFS
        while (ansSet.size() > 2) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int node = queue.poll();

                ansSet.remove(node);

                for (Integer near : dependencies.get(node)) {
                    int degree = degreeMap.get(near) - 1;

                    degreeMap.put(near, degree);
                    dependencies.get(near).remove(node);

                    if (degree == 1) {
                        queue.offer(near);
                    }
                }
            }
        }

        return new ArrayList<>(ansSet);
    }

}