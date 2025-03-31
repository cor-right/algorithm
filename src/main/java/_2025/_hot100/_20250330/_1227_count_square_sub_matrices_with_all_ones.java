package _2025._hot100._20250330;

/**
 * 统计全为 1 的正方形子矩阵
 *
 * @author 佳叙
 * @date 2025/3/30
 * @description <a href="https://leetcode.cn/problems/count-square-submatrices-with-all-ones/description/"/>
 */
public class _1227_count_square_sub_matrices_with_all_ones {

    /**
     * Dynamic planning.
     *
     * @param matrix
     * @return
     */
    public int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];

        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
                    count += dp[i + 1][j + 1];
                }
            }
        }

        return count;
    }

}