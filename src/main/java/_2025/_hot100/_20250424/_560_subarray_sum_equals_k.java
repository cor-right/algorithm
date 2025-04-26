package _2025._hot100._20250424;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为K的子数组
 *
 * @author 佳叙
 * @date 2025/4/25
 * @description <a href="https://leetcode.cn/problems/subarray-sum-equals-k/description/?envType=study-plan-v2&envId=top-100-liked"/>
 */
public class _560_subarray_sum_equals_k {

    /**
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int ans = 0;
        for (int i = 1; i <= prefix.length; i++) {
            for (int j = 0; j < i; j++) {
                if (prefix[i] - prefix[j] == k) {
                    ans++;
                }
            }
        }

        return ans;

    }

    /**
     * 有种DP 的感觉
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySumWithMap(int[] nums, int k) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 1);

        int cnt = 0;
        int pre = 0;
        for (int num : nums) {
            cnt += memo.getOrDefault(pre + num - k, 0);
            pre += num;
            memo.put(pre, memo.getOrDefault(pre, 0) + 1);
        }

        return cnt;
    }

}