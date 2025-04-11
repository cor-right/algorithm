package _2025.subjects._14_dp_2d;

import java.util.Arrays;

/**
 * 不同的子序列
 *
 * @author 佳叙
 * @date 2025/4/11
 * @description <a href="https://leetcode.cn/problems/distinct-subsequences/description/"/>
 */
public class _115_distinct_sub_sequences {

    /**
     * Dynamic planning.
     *
     * 这段代码运用动态规划思想，构建二维数组memo，以memo[i][j]表示s的前j个字符中t的前i个字符出现的不同子序列个数。
     * 通过双重循环逐字符对比，根据字符是否相等，利用之前计算的结果递推得出当前位置的子序列个数。
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        // Row: s, Col: t
        int[][] memo = new int[t.length() + 1][s.length() + 1];
        Arrays.fill(memo[0], 1);

        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                char tc = t.charAt(i - 1);
                char sc = s.charAt(j - 1);

                if (sc == tc) {
                    memo[i][j] += (memo[i - 1][j - 1] + memo[i][j - 1]);
                } else {
                    memo[i][j] = memo[i][j - 1];
                }
            }
        }

        return memo[t.length()][s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new _115_distinct_sub_sequences().numDistinct("babgbag", "bag"));
    }



}