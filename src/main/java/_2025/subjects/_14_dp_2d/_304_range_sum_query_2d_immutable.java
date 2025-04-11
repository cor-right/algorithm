package _2025.subjects._14_dp_2d;

/**
 * 二维区域和检索 - 矩阵不可变
 *
 * @author 佳叙
 * @date 2025/4/11
 * @description <a href="https://leetcode.cn/problems/range-sum-query-2d-immutable/description/"/>
 */
public class _304_range_sum_query_2d_immutable {

    private int[][] matrixSum;

    /**
     * Your NumMatrix object will be instantiated and called as such:
     * NumMatrix obj = new NumMatrix(matrix);
     * int param_1 = obj.sumRegion(row1,col1,row2,col2);
     *
     * 二维的前缀和罢了.
     *
     * @param matrix
     */
    public _304_range_sum_query_2d_immutable(int[][] matrix) {
        int[][] memo = new int[matrix.length + 1][matrix[0].length + 1];

        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                memo[i][j] = matrix[i - 1][j - 1] + memo[i - 1][j] + memo[i][j - 1] - memo[i - 1][j - 1];
            }
        }

        this.matrixSum = memo;
    }

    /**
     *
     *
     * @param row1
     * @param col1
     * @param row2
     * @param col2
     * @return
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int leftX = row1 + 1;
        int leftY = col1 + 1;

        int rightX = row2 + 1;
        int rightY = col2 + 1;

        return matrixSum[rightX][rightY] - matrixSum[leftX - 1][rightY] - matrixSum[rightX][leftY - 1] + matrixSum[leftX - 1][leftY - 1];
    }

}