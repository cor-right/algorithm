package _2025.subjects._10_graph_bfs_2;

import java.util.*;

/**
 * K 站中转内最便宜的航班
 *
 * @author 佳叙
 * @date 2025/4/6
 * @description <a href="https://leetcode.cn/problems/cheapest-flights-within-k-stops/description/"/>
 */
public class _787_cheapest_flights_within_k_stops {

    /**
     *
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param k
     * @return
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Build graph.
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], m -> new ArrayList<>()).add(new int[] {flight[1], flight[2]});
        }

        // Traversal.
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[] {src, 0, 0});

        int[] minStops = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int position = node[0];
            int price    = node[1];
            int stops    = node[2];

            if (position == dst) {
                return price;
            }

            if (stops > k || stops >= minStops[position]) {
                continue;
            }
            minStops[position] = stops;

            List<int[]> neighbors = graph.getOrDefault(position, new ArrayList<>());
            for (int[] next : neighbors) {
                queue.offer(new int[] {next[0], price + next[1], stops + 1});
            }
        }

        return -1;
    }

}