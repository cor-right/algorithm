package _2025._hot100._20250503;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 滑动窗口最大值，单调队列
 *
 * @author 佳叙
 * @date 2025/5/3
 * @description <a href=""/>
 */
public class _239_sliding_window_maximum {

    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length];

        Deque<Integer> queue = new ArrayDeque<>();
        for (int l = 1 - k, r = 0; r < nums.length; l++, r++) {
            // Poll
            if (l > 0 && nums[l - 1] == queue.getFirst()) {
                queue.removeFirst();
            }

            // Offer
            while (!queue.isEmpty() && queue.getLast() < nums[r]) {
                queue.removeLast();
            }
            queue.addLast(nums[r]);

            ans[l] = queue.getFirst();
        }

        return ans;
    }

}