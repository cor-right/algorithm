package hot100;

/**
 * 10. Regular Expression Matching
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.​​​​
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 20
 * 1 <= p.length <= 30
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '.', and '*'.
 * It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 *
 *
 */
public class Hot10 {

    /**
     *
     * si 是字符串长度，
     * pi 是正则长度
     *
     * 空的 pi，可以匹配空的si，其他都不可以匹配
     * 空的 si，可以匹配空的pi，以及类似 ".*"、"a*"之类的情况，需要状态转移
     *
     * 如果是 "bbb", "a*"，dp[0][1] = false，dp[0][2] = dp[0][0] = true
     *
     * 因此
     * dp[0][0] == true
     *
     * dp计算，以s和p的长度为阶段，以是否可以匹配为状态，区分两种场景
     *
     * 非*
     *     精确匹配，如果 s[i] == p[j] || p[j] == "."，则看之前的匹配是否一致。这种s、p都是要增长的，所以是 -1
     *
     * 是*
     *     如果 s[i] == p[j - 1]，则 dp[i] == dp[i - 1][j] || dp[i][j - 2]，
     *     含义是将相同的s的字符不断向左平移，相当于匹配所有相同字符，直到不相同。不同的时候，判断当前不同的，是否和前两个的匹配规则一致。
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int si = 0; si <= s.length(); si++) {
            for (int pi = 1; pi <= p.length(); pi++) {
                if (p.charAt(pi - 1) == '*') {
                    dp[si][pi] = dp[si][pi - 2];

                    if (match(s, p, si, pi - 1)) {
                        dp[si][pi] |= dp[Math.max(0, si - 1)][pi];
                    }

                } else {
                    if (match(s, p, si, pi)) {
                        dp[si][pi] = dp[Math.max(0, si - 1)][pi - 1];
                    }
                }

            }
        }

        return dp[s.length()][p.length()];

    }

    /**
     * match 代表当前位置的字符是否相同
     * @param s
     * @param p
     * @param si
     * @param pi
     * @return
     */
    private static boolean match(String s, String p, int si, int pi) {
        // si == 0，代表空的s，空的s与任何字符都不匹配，只能匹配空
        if (si == 0) {
            return false;
        }

        return p.charAt(pi - 1) == '.' || s.charAt(si - 1) == p.charAt(pi - 1);
    }


    public static void main(String[] rags) {
        System.out.println(isMatch("ab", ".*ab"));

        // dp[0][3] == dp[0][2] == dp[0][0] == true
    }

}
