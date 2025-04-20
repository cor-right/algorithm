package _2025._hot100._20250420;

import java.util.*;

/**
 * 最长递增子序列
 *
 * @author 佳叙
 * @date 2025/4/20
 * @description <a href="https://leetcode.cn/problems/longest-increasing-subsequence/description/"/>
 */
public class _300_longest_increasing_subsequence {

    /**
     * 单调栈
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
            ans = Math.max(ans, memo[i]);
        }

        return ans;
    }

    /**
     * 相同长度下，记录尽量小的那个数字，这样就可以维护一个递增区间。使用二分查找来寻找和替换对应的数字，实现 O(nlog_n)
     *
     * @param nums
     * @return
     */
    private int lengthOfLISWithBinarySearch(int[] nums) {
        return 0;
    }


}