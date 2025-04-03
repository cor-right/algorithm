package _2025.subjects._4_stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 下一个更大的元素
 *
 * @author 佳叙
 * @date 2025/4/3
 * @description <a href="https://leetcode.cn/problems/next-greater-element-i/description/"/>
 */
public class _496_next_greater_element {

    /**
     * HashMap + Monotone increasing stack.
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> greaterMap = new HashMap<>();

        // Build map
        Deque<Integer> stack = new LinkedList<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            greaterMap.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }

        // Build ans
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = greaterMap.get(nums1[i]);
        }

        return ans;
    }

}