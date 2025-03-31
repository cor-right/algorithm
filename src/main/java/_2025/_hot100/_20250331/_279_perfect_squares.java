package _2025._hot100._20250331;

/**
 * 完全平方数
 *
 * <p>
 *     完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * </p>
 *
 * @author 佳叙
 * @date 2025/3/31
 * @description <a href="https://leetcode.cn/problems/perfect-squares/description/"/>
 */
public class _279_perfect_squares {

    /**
     * Dynamic planning.
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

}