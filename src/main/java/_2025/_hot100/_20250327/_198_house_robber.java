package _2025._hot100._20250327;

/**
 * 打家劫舍
 *
 * @author 佳叙
 * @date 2025/3/27
 * @description <a href="https://leetcode.cn/problems/house-robber/description/"/>
 */
public class _198_house_robber {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length + 3];
        for (int i = 0; i < nums.length; i++) {
            dp[i + 3] = Math.max(dp[i + 2], nums[i] + Math.max(dp[i + 1], dp[i]));
        }

        return dp[nums.length + 2];
    }

}