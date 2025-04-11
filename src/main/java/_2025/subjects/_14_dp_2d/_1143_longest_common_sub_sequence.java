package _2025.subjects._14_dp_2d;

/**
 * 最长公共子序列
 *
 * @author 佳叙
 * @date 2025/4/11
 * @description <a href="https://leetcode.cn/problems/longest-common-subsequence/"/>
 */
public class _1143_longest_common_sub_sequence {


    /**
     *
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                char ch1 = text1.charAt(i - 1);
                char ch2 = text2.charAt(j - 1);

                memo[i][j] = Math.max(memo[i][j], ch1 == ch2 ? memo[i - 1][j - 1] + 1 : memo[i - 1][j - 1]);
                memo[i][j] = Math.max(memo[i][j], memo[i - 1][j]);
                memo[i][j] = Math.max(memo[i][j], memo[i][j - 1]);
            }
        }

        return memo[text1.length()][text2.length()];
    }

}