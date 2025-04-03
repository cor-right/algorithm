package _2025.subjects._4_stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 下一个更大的元素 Ⅱ
 *
 * @author 佳叙
 * @date 2025/4/3
 * @description <a href="https://leetcode.cn/problems/next-greater-element-ii/"/>
 */
public class _503_next_greater_element_2 {

    /**
     * 这一题
     * - 核心是，单调栈的应用
     * - 和第一题的区别，主要是循环数组，朴素思想是直接拉直，可以两个循环遍历两次，也可以拼接形成一个新数组，也可以直接取模，不过时间复杂度都是 O(2 * n)
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            int index = i % nums.length;

            while (!stack.isEmpty() && stack.peek() <= nums[index]) {
                stack.pop();
            }

            ans[index] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[index]);
        }

        return ans;
    }

}