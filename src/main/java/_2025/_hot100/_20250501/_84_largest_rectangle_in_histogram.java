package _2025._hot100._20250501;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 柱状图中最大的矩形
 *
 * @author 佳叙
 * @date 2025/5/1
 * @description <a href=""/>
 */
public class _84_largest_rectangle_in_histogram {

    /**
     *
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int[] columns = new int[heights.length + 2];
        System.arraycopy(heights, 0, columns, 1, heights.length);

        Deque<Integer> increasing = new ArrayDeque<>();

        int ans = 0;
        for (int i = 0; i < columns.length; i++) {
            while (!increasing.isEmpty() && columns[increasing.peek()] > columns[i]) {
                int cur = increasing.pop();
                if (!increasing.isEmpty()) {
                    ans = Math.max(ans, columns[cur] * (i - increasing.peek() - 1));
                }
            }

            increasing.push(i);
        }

        return ans;
    }

}