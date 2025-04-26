package _2025._hot100._20250424;

/**
 * 回文子串
 *
 * @author 佳叙
 * @date 2025/4/25
 * @description <a href=""/>
 */
public class _647_palindrome_substring {

    /**
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        boolean[][] memo = new boolean[s.length()][s.length()];

        int ans = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = j; i >= 0; i--) {
                if (memo[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || memo[i + 1][j - 1])) {
                    ans++;
                }
            }
        }

        return ans;
    }

}