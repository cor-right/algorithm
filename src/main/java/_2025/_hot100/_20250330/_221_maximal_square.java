package _2025._hot100._20250330;

import java.util.stream.Stream;

/**
 * 最大正方形
 *
 * @author 佳叙
 * @date 2025/3/30
 * @description <a href="https://leetcode.cn/problems/maximal-square/description/"/>
 */
public class _221_maximal_square {

    /**
     * Dynamic planning. 以右下角为准，看左上、左、上的正方形面积的最小值。
     *
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];

        double max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Stream.of(dp[i][j], dp[i + 1][j], dp[i][j + 1]).min(Integer::compareTo).orElse(0) + 1;
                    max = Math.max(Math.pow(dp[i + 1][j + 1], 2.0), max);
                }
            }
        }

        return (int) max;
    }

}