package _2025.subjects._6_hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 无重复字符的最长子串
 *
 * @author 佳叙
 * @date 2025/4/4
 * @description <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/"/>
 */
public class _3_longest_substring_without_repeating_characters {

    /**
     * 1. 双指针，滑动窗口
     * 2. 哈希表，记录上一次元素出现的位置
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;

        Map<Character, Integer> lastIndex = new HashMap<>(26);

        int pre = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            pre = Math.max(pre, Optional.ofNullable(lastIndex.get(ch)).orElse(-1));
            max = Math.max(max, i - pre);

            lastIndex.put(ch, i);
        }

        return max;
    }

}