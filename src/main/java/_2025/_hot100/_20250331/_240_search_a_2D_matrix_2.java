package _2025._hot100._20250331;

/**
 * 搜索二维矩阵Ⅱ
 *
 * @author 佳叙
 * @date 2025/3/31
 * @description <a href="https://leetcode.cn/problems/search-a-2d-matrix-ii/description/"/>
 */
public class _240_search_a_2D_matrix_2 {

    /**
     * 矩阵旋转后，具备向左边小，向右边大的特性，和二叉搜索树类似.
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // Form top-right to bottom-left

        int i = 0;
        int j = matrix[0].length - 1;

        while (i >= 0 && j >= 0 && i < matrix.length && j < matrix[0].length) {
            if (target == matrix[i][j]) {
                return true;
            }

            if (target < matrix[i][j]) {
                j--;
            }
            else {
                i++;
            }
        }
        return false;
    }

}