package _2025._hot100._20250428;

/**
 * 搜索二维矩阵
 *
 * @author 佳叙
 * @date 2025/4/28
 * @description <a href=""/>
 */
public class _74_search_a_2d_matrix {

    /**
     * 行列分别二分搜索，尽量大
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        }

        // Find row
        int left = 0;
        int right = matrix.length - 1;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            if (matrix[mid][0] == target) {
                return true;
            }

            if (matrix[mid][0] < target) {
                left = mid;
            }
            else {
                right = mid - 1;
            }
        }

        int row = left;

        left = 0;
        right = matrix[0].length;

        // Find col
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (matrix[row][mid] == target) {
                return true;
            }

            if (matrix[row][mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return false;
    }

}