package _2025.subjects._12_search_dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 佳叙
 * @date 2025/4/7
 * @description <a href="https://leetcode.cn/problems/word-break/"/>
 */
public class _139_word_break {

    /**
     * 对于单个 array / string 来说，一般只有 2 种状态定义
     * 1. i == index or problem length -> dp[i] 代表 [0, i) 的答案
     * 2. i, j == indexes -> dp[i][j] 代表 array[i] ~ array[j] 这段 sub array 的答案
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (word.length() <= i && word.equals(s.substring(i - word.length(), i))) {
                    dp[i] = dp[i - word.length()];
                }
            }
        }

        return dp[s.length()];
    }

}