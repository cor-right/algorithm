package _2025.subjects._13_dp_1d;

/**
 * 最大子数组和
 *
 * @author 佳叙
 * @date 2025/4/10
 * @description <a href="https://leetcode.cn/problems/maximum-subarray/description/"/>
 */
public class _53_maximum_sub_array {

    /**
     * 子问题：更少数量的数字的和
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int pre = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = Math.max(pre + nums[i], nums[i]);

            max = Math.max(max, sum);
            pre = sum;
        }

        return max;
    }

}