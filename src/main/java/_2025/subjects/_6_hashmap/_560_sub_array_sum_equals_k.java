package _2025.subjects._6_hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为 K 的子数组
 *
 * @author 佳叙
 * @date 2025/4/4
 * @description <a href="https://leetcode.cn/problems/subarray-sum-equals-k/description/"/>
 */
public class _560_sub_array_sum_equals_k {

    /**
     * 1. 暴力枚举 O(n^2)
     * 2. 前缀和 + 哈希表：所有的子数组都可以用 [0, y] - [0, x] 来表示，子区间问题，很多都会用到前缀和的思路，哈希表则是用于加速查找 O(n)
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        int cnt = 0;
        int pre = 0;
        for (int num : nums) {
            cnt += preSum.getOrDefault(pre + num - k, 0);
            pre += num;
            preSum.put(pre, preSum.getOrDefault(pre, 0) + 1);
        }

        return cnt;
    }

}