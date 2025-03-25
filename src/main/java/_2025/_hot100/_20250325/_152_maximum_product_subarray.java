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
     * 记录的是正负最大值
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        long max = Long.MIN_VALUE;

        int[] maxDP = new int[nums.length];
        int[] minDP = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            maxDP[i] = nums[i];
            minDP[i] = nums[i];
        }

        for (int i = 1; i < nums.length; i++) {

        }



    }

}