package _2025._hot100._20250421;

/**
 * 打家劫舍
 *
 * @author 佳叙
 * @date 2025/4/21
 * @description <a href="https://leetcode.cn/problems/house-robber/description/?envType=study-plan-v2&envId=top-100-liked"/>
 */
public class _198_house_robber {

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。
     * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            memo[i] = nums[i];

            if (i >= 2) {
                memo[i] = Math.max(memo[i], nums[i] + memo[i - 2]);
            }
            if (i >= 3) {
                memo[i] = Math.max(memo[i], nums[i] + memo[i - 3]);
            }

            max = Math.max(max, memo[i]);
        }

        return max;
    }

}