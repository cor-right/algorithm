package _2025._hot100._20250324;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.List;

/**
 * 单词拆解
 *
 * @author 佳叙
 * @date 2025/3/24
 * @description <a href="https://leetcode.cn/problems/word-break/description/"/>
 */
public class _139_word_break {

    /**
     * Dynamic Planning.
     *
     * <p>
     *     输入: s = "leetcode", wordDict = ["leet", "code"]
     *     输出: true
     *     解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
     * </p>
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
                if (i < word.length()) {
                    continue;
                }

                dp[i] = word.equals(s.substring(i - word.length(), i)) && dp[i - word.length()];
                if (dp[i]) {
                    break;
                }
            }
        }

        return dp[s.length()];
    }

}