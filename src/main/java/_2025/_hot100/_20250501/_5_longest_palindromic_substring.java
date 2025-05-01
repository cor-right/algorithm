package _2025._hot100._20250501;

/**
 * 最长回文子串
 *
 * @author 佳叙
 * @date 2025/5/1
 * @description <a href=""/>
 */
public class _5_longest_palindromic_substring {

    /**
     *
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        boolean[][] memo = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            memo[i][i] = true;
        }

        int left  = 0;
        int right = 0;
        int ans   = 1;

        for (int len = 2; len <= s.length(); len++) {
            for (int i = 0; i < s.length() - len + 1; i++) {
                int j = i + len - 1;

                if (s.charAt(i) != s.charAt(j)) {
                    memo[i][j] = false;
                }
                else {
                    memo[i][j] = j - i < 2 || memo[i + 1][j - 1];
                    if (memo[i][j] &&  j - i + 1 > ans) {
                        right = j;
                        left  = i;
                        ans = j - i + 1;
                    }
                }
            }
        }

        return s.substring(left, right + 1);
    }


}