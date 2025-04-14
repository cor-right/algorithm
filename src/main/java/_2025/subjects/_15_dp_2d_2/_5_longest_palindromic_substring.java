package _2025.subjects._15_dp_2d_2;

/**
 * 最长回文子串
 *
 * @author 佳叙
 * @date 2025/4/11
 * @description <a href="https://leetcode.cn/problems/longest-palindromic-substring/description/"/>
 */
public class _5_longest_palindromic_substring {

    private String ans = "";

    /**
     *
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        return backward(s);
    }

    /**
     * 正向DP，从小规模的问题出发逐步扩大规模
     *
     * @return
     */
    private String forward(String s) {
        boolean[][] memo = new boolean[s.length() + 1][s.length() + 1];
        memo[0][0] = true;

        for (int i = 1; i < s.length(); i++) {
            memo[i][i] = true;
            memo[i][i - 1] = true;
        }

        String ans = s.substring(0, 1);
        for (int len = 2; len <= s.length(); len++) {
            for (int left = 0; left <= s.length() - len; left++) {
                int right = left + len - 1;

                memo[left][right] = (s.charAt(left) == s.charAt(right) && memo[left + 1][right - 1]);
                if (memo[left][right]) {
                    ans = s.substring(left, right + 1);
                }
            }
        }

        return ans;
    }

    /**
     * DFS
     *
     * @param s
     * @return
     */
    private String backward(String s) {
        ans = s.substring(0, 1);
        recursion(s, new Boolean[s.length()][s.length()], 0, s.length() - 1);
        return ans;
    }

    private boolean recursion(String s, Boolean[][] memo, int left, int right) {
        if (left >= right) {
            memo[left][right] = true;
            return true;
        }

        if (memo[left][right] != null) {
            return memo[left][right];
        }

        if (recursion(s, memo, left + 1, right - 1) && s.charAt(left) == s.charAt(right)) {
            if (ans.length() < right - left + 1) {
                ans = s.substring(left, right + 1);
            }
            memo[left][right] = true;
        }
        else {
            recursion(s, memo, left + 1, right);
            recursion(s, memo, left, right - 1);
            memo[left][right] = false;
        }
        return memo[left][right];
    }

    public static void main(String[] args) {
        System.out.println(new _5_longest_palindromic_substring().forward("bb"));
    }

}