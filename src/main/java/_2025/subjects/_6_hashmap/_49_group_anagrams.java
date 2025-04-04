package _2025.subjects._6_hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 字母异位词分组
 *
 * @author 佳叙
 * @date 2025/4/4
 * @description <a href="https://leetcode.cn/problems/group-anagrams/description/"/>
 */
public class _49_group_anagrams {

    /**
     * 本质是字母的数量相同，朴素的想法是直接排序，也可以用计数结果拼成字符串，后者时间复杂度低一点
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            int[] counts = new int[26];

            for (char ch : str.toCharArray()) {
                counts[ch - 'a']++;
            }

            StringBuilder keyBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                keyBuilder.append((char)('a' + i));
                keyBuilder.append(counts[i]);
            }

            groups.computeIfAbsent(keyBuilder.toString(), k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(groups.values());
    }


}