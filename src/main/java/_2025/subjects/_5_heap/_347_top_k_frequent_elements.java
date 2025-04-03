package _2025.subjects._5_heap;

import java.util.*;

/**
 * 前 K 个高频元素
 *
 * @author 佳叙
 * @date 2025/4/4
 * @description <a href="https://leetcode.cn/problems/top-k-frequent-elements/"/>
 */
public class _347_top_k_frequent_elements {

    /**
     * 显然，堆管理的是元素的频次
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num : nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            if (heap.size() < k || heap.peek().getValue() < entry.getValue()) {
                heap.offer(entry);
            }

            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll().getKey();
        }

        return ans;
    }

}