package _2025.subjects._13_dp_1d;

/**
 * 整数拆分
 *
 * @author 佳叙
 * @date 2025/4/10
 * @description <a href="https://leetcode.cn/problems/integer-break/description/"/>
 */
public class _343_integer_break {

    /**
     * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
     * 返回你可以获得的最大乘积 。
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                memo[i] = Math.max(memo[i], Math.max(j * (i - j), j * memo[i - j]));
            }
        }

        return memo[n];
    }

}