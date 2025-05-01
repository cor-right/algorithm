package _2025._hot100._20250428;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 每日温度
 *
 * @author 佳叙
 * @date 2025/4/28
 * @description <a href=""/>
 */
public class _739_daily_temperatures {

    /**
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];

        Deque<Integer> decreasing = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!decreasing.isEmpty() && temperatures[decreasing.peek()] < temperatures[i]) {
                ans[decreasing.peek()] = i - decreasing.peek();
                decreasing.pop();
            }
            decreasing.push(i);
        }

        return ans;
    }

}