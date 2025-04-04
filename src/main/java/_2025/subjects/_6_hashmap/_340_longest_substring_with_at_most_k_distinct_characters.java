package _2025.subjects._6_hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 至多包含 K 个字符的最长字串
 *
 * @author 佳叙
 * @date 2025/4/4
 * @description <a href="https://leetcode.cn/problems/longest-substring-with-at-most-k-distinct-characters/"/>
 */
public class _340_longest_substring_with_at_most_k_distinct_characters {

    /**
     * 仍然是双指针（滑动窗口） + 哈希表，窗口内的元素就是 K 个不同元素组成的子串.
     * 注意，这里哈希表记录的就不是位置了，而是出现次数.
     *
     * @param s
     * @param k
     * @return
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int max = 0;
        Map<Character, Integer> appearanceCnt = new HashMap<>();

        int pre = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            appearanceCnt.put(ch, appearanceCnt.getOrDefault(ch, 0) + 1);

            while (appearanceCnt.size() > k) {
                char remove = s.charAt(pre++);

                int remainCnt = appearanceCnt.get(remove) - 1;
                if (remainCnt == 0) {
                    appearanceCnt.remove(remove);
                } else {
                    appearanceCnt.put(remove, remainCnt);
                }
            }

            max = Math.max(max, i - pre + 1);
        }

        return max;
    }

    public static void main(String[] arsg) {
        System.out.println(new _340_longest_substring_with_at_most_k_distinct_characters().lengthOfLongestSubstringKDistinct("abaccc", 2));
    }
}