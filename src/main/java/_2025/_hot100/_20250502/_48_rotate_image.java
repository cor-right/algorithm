package _2025._hot100._20250502;

/**
 * @author 佳叙
 * @date 2025/5/2
 * @description <a href=""/>
 */
public class _48_rotate_image {

    /**
     *
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if (matrix.length == 1) {
            return ;
        }

        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < (matrix.length + 1) / 2; j++) {
                int temp  = matrix[i][j];

                matrix[i][j] = matrix[matrix.length - j - 1][i];
                matrix[matrix.length - j - 1][i] = matrix[matrix.length - i - 1][matrix.length - j - 1];
                matrix[matrix.length - i - 1][matrix.length - j - 1] = matrix[j][matrix.length - i - 1];
                matrix[j][matrix.length - i - 1] = temp;
            }
        }
    }


//    class Solution {
//        public void rotate(int[][] matrix) {
//            // 本质是行列转置
//            for (int i = 0; i < matrix.length / 2; i++) {
//                for (int j = 0; j< (matrix.length + 1) / 2; j++) {
//                    exchange(matrix, i, j);
//                }
//
//            }
//        }
//
//        private void exchange(int[][] matrix, int x, int y) {
//            int x2 = matrix.length - 1 - x;
//            int y2 = matrix.length - 1 - y;
//
//            int temp = matrix[x][y];
//            matrix[x][y] = matrix[y2][x];
//            matrix[y2][x] = matrix[x2][y2];
//            matrix[x2][y2] = matrix[y][x2];
//            matrix[y][x2] = temp;
//        }
//
//    }


}