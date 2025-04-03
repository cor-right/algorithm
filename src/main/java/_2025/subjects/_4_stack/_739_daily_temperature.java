package _2025.subjects._4_stack;

import java.util.Stack;

/**
 * 每日温度
 *
 * <p>
 *     给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * </p>
 *
 * <p>
 *     Stack Principle.
 *     - 在 arr[i] 左侧的所有比 arr[i] 大的数（单调栈）
 *     - 递归之前函数的状态（Call Stack）
 * </p>
 *
 * <p>
 *     Target: Find the distance to the next greater element for each arr[i].
 *     Stack Definition: Using monotone increasing stack.（单调递增栈）
 *
 * </p>
 *
 * @author 佳叙
 * @date 2025/4/3
 * @description <a href="https://leetcode.cn/problems/daily-temperatures/description/"/>
 */
public class _739_daily_temperature {

    /**
     * From right to left.
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans[i] = 0;
            }
            else {
                ans[i] = stack.peek() - i;
            }
            stack.push(i);
        }

        return ans;
    }

}