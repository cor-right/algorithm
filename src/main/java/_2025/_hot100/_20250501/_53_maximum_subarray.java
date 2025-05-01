package _2025._hot100._20250501;

/**
 * 最大子数组和
 *
 * @author 佳叙
 * @date 2025/5/1
 * @description <a href=""/>
 */
public class _53_maximum_subarray {

    /**
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int pre = 0;

        for (int num : nums) {
            ans = Math.max(ans, pre = num + Math.max(0, pre));
        }

        return ans;
    }

}