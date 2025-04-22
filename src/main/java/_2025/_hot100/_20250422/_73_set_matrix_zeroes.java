package _2025._hot100._20250422;

/**
 * 矩阵置零
 *
 * @author 佳叙
 * @date 2025/4/22
 * @description <a href="https://leetcode.cn/problems/set-matrix-zeroes/?envType=study-plan-v2&envId=top-100-liked"/>
 */
public class _73_set_matrix_zeroes {


    /**
     * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
     *
     * 分别使用第一行和第一列来标记是否是要置零
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int i = 0; i < matrix[0].length; i++) {
            firstRowZero |= matrix[0][i] == 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            firstColZero |= matrix[i][0] == 0;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0 || (i == 0 && firstRowZero) || (j == 0 && firstColZero)) {
                    matrix[i][j] = 0;
                }
            }
        }

    }



}