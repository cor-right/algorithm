package _2025._hot100._20250324;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 佳叙
 * @date 2025/3/24
 * @description <a href="https://leetcode.cn/problems/longest-consecutive-sequence/description/"/>
 */
public class _128_longest_consecutive_sequence {

    /**
     * Hash Table
     */
    public int longestConsecutive(int[] nums) {
        int maxLen = 0;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (Integer current : set) {
            if (set.contains(current - 1)) {
                continue;
            }

            int len = 1;
            int num = current;
            while (set.contains(++num)) {
                len++;
            }

            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }

}