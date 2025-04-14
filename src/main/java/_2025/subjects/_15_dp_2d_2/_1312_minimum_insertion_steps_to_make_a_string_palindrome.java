package _2025.subjects._15_dp_2d_2;

/**
 * 让字符串变成回文字符串的最少插入次数
 *
 * @author 佳叙
 * @date 2025/4/14
 * @description <a href="https://leetcode.cn/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/"/>
 */
public class _1312_minimum_insertion_steps_to_make_a_string_palindrome {

    /**
     *
     * 回文字符串的本质是，将字符串反转后，求其最长的公共子序列
     *
     * leetcode
     * edocteel
     * e、d、e，三个公共，所以需要5个新增
     *
     * mbadm
     * mdabm
     * 2个公共，所需要3个新增
     *
     * 填表吧，我真牛比
     *
     * @param s
     * @return
     */
    public int minInsertions(String s) {
        int[][] memo = new int[s.length() + 2][s.length() + 2];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = s.length(); j >= 1; j--) {
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    memo[i][j] = memo[i - 1][j + 1] + 1;
                } else {
                    memo[i][j] = Math.max(memo[i][j + 1], memo[i - 1][j]);
                }
            }
        }

        return s.length() - memo[s.length()][1];
    }

}