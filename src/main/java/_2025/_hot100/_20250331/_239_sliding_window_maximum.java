package _2025._hot100._20250331;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 滑动窗口最大值
 *
 * @author 佳叙
 * @date 2025/3/31
 * @description <a href="https://leetcode.cn/problems/sliding-window-maximum/description/"/>
 */
public class _239_sliding_window_maximum {


    /**
     * 维护单调队列
     *     - 确保队首始终是最大值
     *     - 队列内部存在单调递减特性，这样可以方便找到第二大的值，并且窗口一直向前，因此只需要第二大的就够了.
     * 双指针，维护窗口范围
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();

        int[] ans = new int[nums.length - k + 1];

        for (int i = 1 - k, j = 0; j < nums.length; i++, j++) {
            // Remove old
            if (i > 0 && nums[i - 1] == deque.getFirst()) {
                deque.removeFirst();
            }

            // Offer new
            while (!deque.isEmpty() && deque.getLast() < nums[j]) {
                deque.removeLast();
            }
            deque.addLast(nums[j]);

            if (i >= 0) {
                ans[i] = deque.getFirst();
            }
        }

        return ans;
    }

}