package _2025._hot100._20250322;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 直方图中举行的最大面积
 *
 * @author jiaxu.zjx
 * @date 2025/3/22 22:44
 * @description <a href="https://leetcode.cn/problems/largest-rectangle-in-histogram/description/"/>
 */
public class _84_largest_rectangle_in_histogram {

    /**
     * 单调栈，单调递增栈
     * - 单调栈的核心作用是帮助我们快速找到每个柱子的左右边界，从而计算出以该柱子为高的最大矩形面积。
     * - 所以栈顶柱子的右边界就是当前矮柱子的位置，因为栈是单调递增的，矮柱子打断了栈顶柱子的“延伸”。
     * - 而其左边界就是上一个比其矮的柱子的位置。
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> incrementStack = new Stack<>();

        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);

        int max = 0;
        for (int i = 0; i < newHeights.length; i++) {
            while (!incrementStack.isEmpty() && newHeights[incrementStack.peek()] > newHeights[i]) {
                max = Math.max(max, (newHeights[incrementStack.pop()] * (i - incrementStack.peek() - 1)));
            }
            incrementStack.push(i);
        }

        return max;
    }

}
