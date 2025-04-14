package _2025.subjects._15_dp_2d_2;

/**
 * @author 佳叙
 * @date 2025/4/14
 * @description <a href="https://leetcode.cn/problems/longest-common-subsequence/description/"/>
 */
public class _1143_longest_common_subsequence {

    /**
     * 子问题：更短的子串
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length() + 1][text2.length() + 1];

        int ans = 0;
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    ans = Math.max(ans, memo[i][j] = memo[i - 1][j - 1] + 1);
                } else {
                    // There are two kinds of shorter substring.
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }

        return ans;
    }

}