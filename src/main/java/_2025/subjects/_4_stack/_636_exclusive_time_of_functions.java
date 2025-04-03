package _2025.subjects._4_stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 函数的独占时间
 *
 * @author 佳叙
 * @date 2025/4/3
 * @description <a href="https://leetcode.cn/problems/exclusive-time-of-functions/"/>
 */
public class _636_exclusive_time_of_functions {

    /**
     * 这里使用线性扫描的思路，将被中断的函数的前半部分和后半部分分别处理就好。
     *
     * @param n
     * @param logs
     * @return
     */
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<int[]> stack = new ArrayDeque<>();

        int[] costs = new int[n];

        for (String log : logs) {
            String[] split = log.split(":");

            int id = Integer.parseInt(split[0]);
            int time = Integer.parseInt(split[2]);

            if ("start".equals(split[1])) {
                if (!stack.isEmpty()) {
                    costs[stack.peek()[0]] += (time - stack.peek()[1]);
                }
                stack.push(new int[] {id, time});
            }
            else {
                int cost = time - stack.pop()[1] + 1;
                costs[id] += cost;

                if (!stack.isEmpty()) {
                    stack.peek()[1] = time + 1;
                }
            }
        }

        return costs;
    }

}