package _2025.subjects._13_dp_1d.hot;

/**
 * 最长有效括号
 *
 * @author 佳叙
 * @date 2025/4/11
 * @description <a href="https://leetcode.cn/problems/longest-valid-parentheses/submissions/"/>
 */
public class _32_longest_valid_parentheses {

    /**
     * I believe which should using dynamic planning.
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int max = 0;
        int[] memo = new int[s.length() + 1];

        for (int i = 1; i <= s.length(); i++) {
            char ch = s.charAt(i - 1);

            if (ch == ')') {
                // First ')' is illegal.
                if (i == 1) {
                    continue;
                }

                // Neighbor.
                if (s.charAt(i - 2) == '(') {
                    memo[i] = memo[i - 2] + 2;
                }

                // Long range before.
                if (s.charAt(i - 2) == ')' && memo[i - 1] != 0) {
                    int beforeIndex = i - 2 - memo[i - 1];
                    if (beforeIndex >= 0) {
                        memo[i] = s.charAt(beforeIndex) == '(' ? memo[i - 1] + 2 + memo[beforeIndex] : 0;
                    }
                }

                max = Math.max(max, memo[i]);
            }
        }

        return max;
    }

}