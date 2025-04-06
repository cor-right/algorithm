package _2025.subjects._10_graph_bfs_2;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 丑数 Ⅱ
 *
 * @author 佳叙
 * @date 2025/4/6
 * @description <a href="https://leetcode.cn/problems/ugly-number-ii/"/>
 */
public class _364_ugly_number_2 {

    /**
     * 丑数 就是质因子只包含 2、3 和 5 的正整数。给你一个整数 n ，请你找出并返回第 n 个 丑数 。
     *
     * 1 2 3 5
     *
     *
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        return nthUglyNumberWithDP(n);

//        int[] nums = new int[] {2, 3, 5};
//        long ans = 1;
//
//        PriorityQueue<Long> queue = new PriorityQueue<>();
//        queue.offer(1L);
//
//        Set<Long> visited = new HashSet<>();
//        visited.add(1L);
//
//        for (int i = 0; i < n; i++) {
//            ans = queue.poll();
//
//            for (int num : nums) {
//                long next = ans * num;
//                if (!visited.contains(next)) {
//                    visited.add(ans * num);
//                    queue.offer(ans * num);
//                }
//            }
//        }
//
//        return (int) ans;
    }

    /**
     * p2 p3 p5 实际上指向的就是，从因子维度出发，其乘积可能存在的最小值.
     *
     * @param n
     * @return
     */
    public int nthUglyNumberWithDP(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n];
        dp[0] = 1;

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        for (int i = 1; i < n; i++) {
            int v2 = dp[p2] * 2;
            int v3 = dp[p3] * 3;
            int v5 = dp[p5] * 5;

            dp[i] = Math.min(Math.min(v2, v3), v5);

            if (dp[i] == v2) {
                p2++;
            }
            if (dp[i] == v3) {
                p3++;
            }
            if (dp[i] == v5) {
                p5++;
            }
        }

        return dp[n - 1];
    }
}