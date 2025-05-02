package _2025._hot100._20250502;

/**
 * @author 佳叙
 * @date 2025/5/2
 * @description <a href=""/>
 */
public class _32_longest_valid_parentheses {


    /**
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s.length() < 2) {
            return 0;
        }

        int ans = 0;
        int[] memo = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {

                if (s.charAt(i - 1) == '(') {
                    memo[i] = i > 1 ? memo[i - 2] + 2 : 2;

                } else {
                    int pre = i - memo[i - 1] - 1;
                    if (pre >= 0 && s.charAt(pre) == '(') {
                        memo[i] = memo[i - 1] + 2 + (pre > 0 ? memo[pre - 1] : 0);
                    }
                }

                ans = Math.max(ans, memo[i]);
            }
        }

        return ans;
    }
    

}