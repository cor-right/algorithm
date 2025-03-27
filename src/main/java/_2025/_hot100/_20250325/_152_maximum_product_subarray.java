package _2025._hot100._20250325;

/**
 * 乘积最大子数组
 *
 * @author 佳叙
 * @date 2025/3/25
 * @description <a href="https://leetcode.cn/problems/maximum-product-subarray/description/"/>
 */
public class _152_maximum_product_subarray {

    /**
     * Dynamic planning.
     *
     * 这题是求数组中子区间的最大乘积，对于乘法，我们需要注意，负数乘以负数，会变成正数。
     * 所以解这题的时候我们需要维护两个变量，当前的最大值，以及最小值，最小值可能为负数。
     * 但没准下一步乘以一个负数，当前的最大值就变成最小值，而最小值则变成最大值了。
     */
    public int maxProduct(int[] nums) {
        int[] maxArr = new int[nums.length];
        int[] minArr = new int[nums.length];

        maxArr[0] = nums[0];
        minArr[0] = nums[0];

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxArr[i] = Math.max(nums[i], Math.max(nums[i] * maxArr[i - 1], nums[i] * minArr[i - 1]));
            minArr[i] = Math.min(nums[i], Math.min(nums[i] * maxArr[i - 1], nums[i] * minArr[i - 1]));

            max = Math.max(max, maxArr[i]);
        }

        return max;

    }

}