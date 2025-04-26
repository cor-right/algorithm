package _2025._hot100._20250425;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数组中第K大的元素
 *
 * @author 佳叙
 * @date 2025/4/26
 * @description <a href=""/>
 */
public class _215_kth_largest_element_in_an_array {


    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k + 1);

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