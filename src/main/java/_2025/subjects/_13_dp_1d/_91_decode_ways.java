package _2025.subjects._13_dp_1d;

/**
 * @author 佳叙
 * @date 2025/4/10
 * @description <a href="https://leetcode.cn/problems/decode-ways/description/"/>
 */
public class _91_decode_ways {

    /**
     * 子问题：更少数字的解码方式，a[i] = a[i - 1] + a[i - 2]，注意一下边界条件
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int[] memo = new int[s.length() + 1];
        memo[0] = 1;

        for (int i = 1; i <= s.length(); i++) {
            int num1 = Integer.parseInt(s.substring(i - 1, i));
            int num2 = i > 1 ? Integer.parseInt(s.substring(i - 2, i)) : 0;

            if (num1 > 0) {
                memo[i] += memo[i - 1];
            }
            if (num2 >= 10 && num2 <= 26) {
                memo[i] += memo[i - 2];
            }
        }

        return memo[s.length()];
    }

}