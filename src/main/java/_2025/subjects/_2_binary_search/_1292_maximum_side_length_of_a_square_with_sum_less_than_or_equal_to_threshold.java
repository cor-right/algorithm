package _2025.subjects._2_binary_search;


/**
 * 元素和小于等于阈值的最大边长
 *
 * <p>
 *     给你一个大小为 m x n 的矩阵 mat 和一个整数阈值 threshold。
 *     请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0 。
 * </p>
 *
 * @author 佳叙
 * @date 2025/4/2
 * @description <a href="https://leetcode.cn/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/description/"/>
 */
public class _1292_maximum_side_length_of_a_square_with_sum_less_than_or_equal_to_threshold {

    /**
     * 计算正方形的面积，使用二维前缀和，前缀和数组 area 中，记录的是 长为 i，宽为 j，从左上到右下的矩形的元素和。
     *
     * @param mat
     * @param threshold
     * @return
     */
    public int maxSideLength(int[][] mat, int threshold) {
        // Build area array
        int[][] area = new int[mat.length + 1][mat[0].length + 1];

        // All area
        for (int i = 1; i <= mat.length; i++) {
            for (int j = 1; j <= mat[0].length; j++) {
                area[i][j] = mat[i - 1][j - 1] + area[i - 1][j] + area[i][j - 1] - area[i - 1][j - 1];
            }
        }

        int max = 0;
        for (int i = 1; i <= area.length; i++) {
            for (int j = 1; j <= area[0].length; j++) {

                int right = Math.min(i, j);
                int left  = 1;

                // Find right
                while (left < right) {
                    int mid = left + (right - left + 1) / 2;

                    if (squareArea(area, i, j, mid) <= threshold) {
                        left = mid;
                    }
                    else {
                        right = mid - 1;
                    }
                }

                if (squareArea(area, i, j, left) <= threshold) {
                    max = Math.max(max, left);
                }
            }
        }

        return max;
    }

    /**
     * 用矩形面积，获取以 [x, y] 为右下角点位的正方形面积
     *
     * @param area
     * @param x
     * @param y
     * @param len
     * @return
     */
    private int squareArea(int[][] area, int x, int y, int len) {
        return area[x][y] - area[x - len][y] - area[x][y - len] + area[x - len][y - len];
    }

}