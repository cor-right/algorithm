package _2025.subjects._16_dp_2d_3;

import java.util.Arrays;

/**
 * 零钱兑换
 *
 * @author 佳叙
 * @date 2025/4/20
 * @description <a href="https://leetcode.cn/problems/coin-change/description/"/>
 */
public class _322_coin_change {

    /**
     * DP
     *
     * 子问题：更小的金额
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && memo[i - coin] != Integer.MAX_VALUE) {
                    memo[i] = Math.min(memo[i], memo[i - coin] + 1);
                }
            }
        }

        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }

    private void prefix() {

        int[] nums = new int[] {1, 2, 3, 4, 5};

        // 制造前缀和数组
        int[] prefix = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            prefix[i] = nums[i - 1] + prefix[i - 1];
        }

        // 填充数组
        Arrays.fill(nums, 1);

        //
    }

}