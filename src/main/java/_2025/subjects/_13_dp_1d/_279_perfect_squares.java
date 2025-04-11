package _2025.subjects._13_dp_1d;

import java.util.Arrays;

/**
 * 完全平方数
 *
 * @author 佳叙
 * @date 2025/4/10
 * @description <a href="https://leetcode.cn/problems/perfect-squares/"/>
 */
public class _279_perfect_squares {

    /**
     * 给你一个整数 n ，返回和为 n 的完全平方数的最少数量。
     * 完全平方数是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
     *
     * <p>
     *     子问题：更小的数
     *     a[i] = j * j + a[i - j * j]
     * </p>
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);

        memo[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                memo[i] = Math.min(memo[i], memo[i - j * j] + 1);
            }
        }

        return memo[n];
    }

}