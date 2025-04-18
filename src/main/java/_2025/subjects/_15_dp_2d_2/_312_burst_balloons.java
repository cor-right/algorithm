package _2025.subjects._15_dp_2d_2;

import java.util.Arrays;

/**
 * 戳气球
 *
 * @author 佳叙
 * @date 2025/4/15
 * @description <a href="https://leetcode.cn/problems/burst-balloons/description/"/>
 */
public class _312_burst_balloons {

    /**
     * 子问题：子序列能产生的硬币数，双指针代表子序列区间
     *
     * 输入：nums = [3,1,5,8]
     * 输出：167
     * 解释：
     * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
     * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
     *
     * [3 1 5 8]
     * [1 5 8]              [3 5 8]                 [3 1 8]                 [3 1 5]
     * [1 5] [5 8] [1 8]    [5 8] [3 8] [3 5]       [1 8] [3 8] [3 1]       [1 5] [3 5] [3 1]
     *
     *
     *
     * 记忆化搜索会更直观一点，填表的话，要注意顺序
     *
     * - 这次是从小到大，而不是从大到小的思路看，把戳气球变成增加气球看成增加气球，这样就可以从小问题推向大问题
     * - 需要三个指针，left、mid、right，填表的方式主要是按照区间大小，从右往左逐步扩大范围，并在期间不断更新
     * - 注意这里用的是开区间
     *
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int[] values = new int[nums.length + 2];
        Arrays.fill(values, 1);
        System.arraycopy(nums, 0, values, 1, nums.length);

        int[][] memo = new int[values.length][values.length];

        for (int left = values.length - 3; left >= 0; left--) {
            for (int right = left + 2; right < values.length; right++) {
                for (int mid = left + 1; mid < right; mid++) {
                    memo[left][right] = Math.max(memo[left][right], memo[left][mid] + memo[mid][right] + values[mid] * values[left] * values[right]);
                }
            }
        }

        return memo[0][values.length - 1];
    }


}