package _2025.subjects._14_dp_2d;

import java.util.Arrays;

/**
 * 下降路径最小和
 *
 * @author 佳叙
 * @date 2025/4/11
 * @description <a href="https://leetcode.cn/problems/minimum-falling-path-sum/description/"/>
 */
public class _931_minimum_falling_path_sum {

    /**
     *
     * @param matrix
     * @return
     */
    public int minFallingPathSum(int[][] matrix) {

        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            memo[0][i] = matrix[0][i];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                memo[i][j] = memo[i - 1][j];

                if (j > 0) {
                    memo[i][j] = Math.min(memo[i][j], memo[i - 1][j - 1]);
                }
                if (j < matrix.length - 1) {
                    memo[i][j] = Math.min(memo[i][j], memo[i - 1][j + 1]);
                }

                memo[i][j] += matrix[i][j];
            }
        }

        return Arrays.stream(memo[matrix.length -1]).min().orElse(0);
    }

}