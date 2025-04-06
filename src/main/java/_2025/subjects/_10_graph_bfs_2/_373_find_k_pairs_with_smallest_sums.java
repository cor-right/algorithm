package _2025.subjects._10_graph_bfs_2;

import java.util.*;

/**
 * 查找和最小的 K 对数字
 *
 * @author 佳叙
 * @date 2025/4/6
 * @description <a href="https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/description/"/>
 */
public class _373_find_k_pairs_with_smallest_sums {

    /**
     *
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]);
        queue.offer(new int[] {0, 0});

        Set<String> visited = new HashSet<>();
        visited.add("0:0");

        for (int i = 0; i < k; i++) {
            int[] pair = queue.poll();
            int p1 = pair[0];
            int p2 = pair[1];

            ans.add(Arrays.asList(nums1[p1], nums2[p2]));

            int nextP1 = p1 + 1;
            int nextP2 = p2 + 1;

            int[] nextPair1 = new int[] {nextP1, p2};
            int[] nextPair2 = new int[] {p1, nextP2};

            if (nextP1 < nums1.length && !visited.contains(nextPair1[0] + ":" + nextPair1[1])) {
                queue.offer(nextPair1);
                visited.add(nextPair1[0] + ":" + nextPair1[1]);
            }
            if (nextP2 < nums2.length && !visited.contains(nextPair2[0] + ":" + nextPair2[1])) {
                queue.offer(nextPair2);
                visited.add(nextPair2[0] + ":" + nextPair2[1]);
            }
        }

        return ans;
    }

}