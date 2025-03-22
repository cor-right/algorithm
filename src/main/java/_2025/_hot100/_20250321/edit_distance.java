package _2025._hot100._20250321;

import java.util.stream.Stream;

/**
 * @author 佳叙
 * @date 2025/3/20
 * @description <a href="https://leetcode.cn/problems/edit-distance/description/"/>
 *
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 */
public class edit_distance {

    /**
     * dp[i][j]=min(dp[i][j−1]+1,dp[i−1][j]+1,dp[i−1][j−1]+(word1[i] !=word2[j]))
     *
     * 现在开始逐个格子填表格。对于每个格子 dp[i][j]，你有三种选择：
     * 加一个积木：从左边的格子 dp[i][j-1] 过来，表示在 word1 的前 i 个积木后面加一个积木，操作数加1。
     * 拿掉一个积木：从上面的格子 dp[i-1][j] 过来，表示从 word1 的前 i 个积木中拿掉一个积木，操作数加1。
     * 换一个积木：从左上角的格子 dp[i-1][j-1] 过来，如果 word1 的第 i 个积木和 word2 的第 j 个积木一样，你不需要换，操作数不变；如果不一样，你需要换一个积木，操作数加1。
     *
     *
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return 0;
        }
        if (word1 == null || word2 == null) {
            return word1 == null ? word2.length() : word1.length();
        }

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                char ch1 = word1.charAt(i - 1);
                char ch2 = word2.charAt(j - 1);

                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Stream.of(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]).min(Integer::compareTo).get() + 1;
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }


}