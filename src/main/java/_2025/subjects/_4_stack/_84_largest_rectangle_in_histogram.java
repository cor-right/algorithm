package _2025.subjects._4_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 柱状图中最大的矩形
 *
 * @author 佳叙
 * @date 2025/4/3
 * @description <a href="https://leetcode.cn/problems/largest-rectangle-in-histogram/"/>
 */
public class _84_largest_rectangle_in_histogram {

    /**
     * Monotone increasing stack.
     *
     * 从左到右，构建单调递增栈，因为左边的柱子如果比右边的低，则以左边的柱子为高的矩形是可以继续延伸的
     * 注意，在计算 Area 的时候，矩形的左边界是当前弹出元素的上一个元素的位置，右边界是下一个比它更小的元素
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        int[] columns = new int[heights.length + 2];
        System.arraycopy(heights, 0, columns, 1, heights.length);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < columns.length; i++) {
            if (stack.isEmpty() || columns[stack.peek()] <= columns[i]) {
                stack.push(i);
            }
            else {
                while (!stack.isEmpty() && columns[stack.peek()] > columns[i]) {
                    int last = stack.pop();

                    // This is important
                    maxArea = Math.max(maxArea, (i - stack.peek() - 1) * columns[last]);
                }
                stack.push(i);
            }
        }

        return maxArea;
    }

}