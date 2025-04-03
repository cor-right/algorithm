package _2025.subjects._5_heap;

import java.util.PriorityQueue;

/**
 * 数组中第 K 个最大的元素
 *
 * <p>
 *     第 K 大是个特征，题目中含第 K 大的基本都是用堆.
 * </p>
 *
 * <p>
 *     三种思路
 *     1. 排序，然后选择其中第 K 个，本题可以使用优化后的二分排序，期望时间复杂度可以
 * </p>
 *
 * @author 佳叙
 * @date 2025/4/4
 * @description <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/description/"/>
 */
public class _215_kth_largest_element_in_an_array {

    /**
     * 求第 K 个最大的元素，就用最小堆，堆顶就是 K 个最大元素中的最小值.
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            if (heap.size() < k || heap.peek() < num) {
                heap.offer(num);
            }

            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.peek();
    }

}