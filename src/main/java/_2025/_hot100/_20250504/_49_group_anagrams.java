package _2025._hot100._20250504;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 佳叙
 * @date 2025/5/4
 * @description <a href=""/>
 */
public class _49_group_anagrams {

    /**
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            groups.computeIfAbsent(Arrays.toString(chars), k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(groups.values());
    }

}