package _2025._hot100._20250423;

import java.util.Arrays;

/**
 * 无重复元素的最长子串
 *
 * @author 佳叙
 * @date 2025/4/23
 * @description <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked"/>
 */
public class _3_longest_substring_without_repeating_characters {


    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int[] memo = new int[128];
        Arrays.fill(memo, -1);

        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (memo[s.charAt(i)] >= 0) {
                j = Math.max(j, memo[s.charAt(i)] + 1);
            }

            memo[s.charAt(i)] = i;

            max = Math.max(max, i - j + 1);
        }

        return max;
    }

//    public static void main(String[] args) {
//        System.out.println(new _3_longest_substring_without_repeating_characters().lengthOfLongestSubstring("abba"));
//    }
}