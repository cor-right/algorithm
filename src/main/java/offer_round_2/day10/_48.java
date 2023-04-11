package offer_round_2.day10;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 * 提示：
 *
 * s.length <= 40000
 * 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class _48 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        return useDoublePointer(s);
    }

    private int useDynamicPrograming(String s) {
        int[] dp = new int[s.length()];
        dp[0] = 1;

        Map<Character, Integer> lastCharMap = new HashMap<>();
        lastCharMap.put(s.charAt(0), 0);

        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            dp[i] = Math.min(dp[i - 1] + 1, i - lastCharMap.getOrDefault(s.charAt(i), -1));

            lastCharMap.put(s.charAt(i), i);
            max = Math.max(dp[i], max);
        }

        return max;
    }

    private int useDoublePointer(String s) {
        Map<Character, Integer> lastCharMap = new HashMap<>();
        lastCharMap.put(s.charAt(0), 0);

        int max = 1;
        int left = -1;
        for (int right = 1; right < s.length(); right++) {
            Integer lastIndex = lastCharMap.get(s.charAt(right));
            if (lastIndex != null) {
                left = Math.max(left, lastIndex);
            }

            max = Math.max(right - left, max);
            lastCharMap.put(s.charAt(right), right);
        }

        return max;
    }

//    public static void main(String[] args) {
//        System.out.println(new _48().lengthOfLongestSubstring("abcabcbb")); // 3
//        System.out.println(new _48().lengthOfLongestSubstring("bbbbb")); // 1
//        System.out.println(new _48().lengthOfLongestSubstring("pwwkew")); // 3
//        System.out.println(new _48().lengthOfLongestSubstring("au")); // 2
//        System.out.println(new _48().lengthOfLongestSubstring("abba")); // 2
//    }

}
