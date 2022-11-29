package offer.day10;

import java.util.HashMap;
import java.util.Map;

/**
 * @code https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=108mt86
 *
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
 *
 * O(nlngn) 以下
 *
 * 首先滑动窗口+哈希表，最直观
 *
 *
 * DP 的目的是空间换时间，dp[i] 存储的数据，是s[i]场景下的最大长度，这种方法可以获取任意地方的最大长度。但没有滑动窗口直观。
 *
 * map(K, V) -> map(字符，上次字符出现的位置 ==> j)
 *
 * j < 0 || （i - j） > dp[i - 1]，证明子串的长度还没有同时包含相同字符，可以继续，则 dp[i] = dp[i - 1] + 1;
 * 否则，dp[i] = j - i
 *
 * abcda
 *
 * 4 4
 *
 */
public class Offer48 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int rs = 0;
        int dp = 0;

        for (int i = 0; i < s.length(); i++) {
            Integer lastIdx = map.get(s.charAt(i));
            if (lastIdx == null || dp < (i - lastIdx)) {
                dp++;
            } else {
                dp = i - lastIdx;
            }

            rs = Math.max(rs, dp);
            map.put(s.charAt(i), i);
        }

        return rs;
    }

}
