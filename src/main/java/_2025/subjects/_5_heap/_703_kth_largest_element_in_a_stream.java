package _2025.subjects._5_heap;

import java.util.PriorityQueue;

/**
 * 数据流中第 K 大的元素
 *
 * @author 佳叙
 * @date 2025/4/4
 * @description <a href="https://leetcode.cn/problems/kth-largest-element-in-a-stream/description/"/>
 */
public class _703_kth_largest_element_in_a_stream {

    private PriorityQueue<Integer> minHeap;
    private int maxSize;

    /**
     * Your KthLargest object will be instantiated and called as such:
     * KthLargest obj = new KthLargest(k, nums);
     * int param_1 = obj.add(val);
     */
    public _703_kth_largest_element_in_a_stream(int k, int[] nums) {
        this.maxSize = k;
        this.minHeap = new PriorityQueue<>();

        for (int num : nums) {
            offer(num);
        }
    }

    public int add(int val) {
        offer(val);
        return this.minHeap.peek();
    }

    private void offer(int num) {
        this.minHeap.offer(num);

        if (this.minHeap.size() > this.maxSize) {
            this.minHeap.poll();
        }
    }

}