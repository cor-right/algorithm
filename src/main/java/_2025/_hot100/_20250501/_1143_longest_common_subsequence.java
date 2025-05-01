package _2025._hot100._20250501;

/**
 * 最长公共子序列
 *
 * @author 佳叙
 * @date 2025/5/1
 * @description <a href=""/>
 */
public class _1143_longest_common_subsequence {

    /**
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                }
                else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }

        return memo[text1.length()][text2.length()];
    }

}