package _2025._hot100._20250331;

/**
 * 零钱兑换
 *
 * <p>
 *     类似于题目：完全平方数 <a href="https://leetcode.cn/problems/perfect-squares/description/"/>
 * </p>
 *
 * <p>
 *     给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *     计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *     你可以认为每种硬币的数量是无限的。
 *
 *
 * </p>
 *
 * @author 佳叙
 * @date 2025/3/31
 * @description <a href="https://leetcode.cn/problems/coin-change/description/"/>
 */
public class _322_coin_change {

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // Amout is i
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

}