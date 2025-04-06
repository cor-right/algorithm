package _2025.subjects._10_graph_bfs_2;

import java.util.*;

/**
 * 网络延迟时间
 *
 * @author 佳叙
 * @date 2025/4/6
 * @description <a href="https://leetcode.cn/problems/network-delay-time/description/"/>
 */
public class _743_network_delay_time {

    /**
     * 这是一个有向图，且权重不一定一致，因此需要
     *
     * @param times
     * @param n
     * @param k
     * @return
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], l -> new ArrayList<>()).add(new int[] {time[1], time[2]});
        }

        Set<Integer> visited = new HashSet<>();
        int maxCost = 0;
        int nodeNum = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[] {k, 0});

        // Traversal.
        while (!queue.isEmpty()) {
            // Pull out the smallest cost element.
            int[] pair = queue.poll();
            int node = pair[0];
            int cost = pair[1];

            if (visited.contains(node)) {
                continue;
            }

            nodeNum++;
            maxCost = Math.max(maxCost, cost);

            visited.add(node);

            List<int[]> nextPairs = graph.getOrDefault(node, new ArrayList<>());
            for (int[] nextPair : nextPairs) {
                queue.offer(new int[] {nextPair[0], nextPair[1] + cost});
            }
        }

        return nodeNum == n ? maxCost : -1;
    }

}