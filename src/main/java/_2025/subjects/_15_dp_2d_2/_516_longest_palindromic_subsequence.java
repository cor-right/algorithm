package _2025.subjects._15_dp_2d_2;

/**
 * 最长回文子序列
 *
 * @author 佳叙
 * @date 2025/4/14
 * @description <a href="https://leetcode.cn/problems/longest-palindromic-subsequence/"/>
 */
public class _516_longest_palindromic_subsequence {

    /**
     *
     *
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        int[][] memo = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            memo[i][i] = 1;
        }

        int ans = 1;
        for (int len = 2; len <= s.length(); len++) {
            for (int left = 0; left <= s.length() - len; left++) {
                int right = left + len - 1;

                if (s.charAt(left) == s.charAt(right)) {
                    ans = Math.max(ans, memo[left][right] = memo[left + 1][right - 1] + 2);
                } else {
                    memo[left][right] = Math.max(memo[left + 1][right], memo[left][right - 1]);
                }
            }
        }

        return ans;
    }

}