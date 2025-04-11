package _2025.subjects._13_dp_1d;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 单词拆分 Ⅱ
 *
 * @author 佳叙
 * @date 2025/4/11
 * @description <a href="https://leetcode.cn/problems/word-break-ii/"/>
 */
public class _140_word_break_2 {

    /**
     * <p>
     *      给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。
     *      注意：词典中的同一个单词可能在分段中被重复使用多次。
     *      输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
     *      输出:["cats and dog","cat sand dog"]
     * </p>
     *
     * <p>
     *     记忆化搜索、记录路径
     *     子问题：前缀
     * </p>
     *
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> memo = new HashMap<>();
        memo.put("", Arrays.asList(""));

        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                // Too long to use
                if (word.length() > i + 1) {
                    continue;
                }

                String right = s.substring(i - word.length() + 1, i + 1);
                String left  = s.substring(0, i - word.length() + 1);
                if (right.equals(word)) {
                    List<String> sentences = memo.getOrDefault(left, new ArrayList<>()).stream().map(p -> (p + " " + word).trim()).collect(Collectors.toList());
                    memo.computeIfAbsent(s.substring(0, i + 1), k -> new ArrayList<>()).addAll(sentences);
                }
            }
        }

        return memo.getOrDefault(s, new ArrayList<>());
    }

}