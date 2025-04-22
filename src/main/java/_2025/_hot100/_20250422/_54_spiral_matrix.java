package _2025._hot100._20250422;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 *
 * @author 佳叙
 * @date 2025/4/22
 * @description <a href="https://leetcode.cn/problems/spiral-matrix/description/?envType=study-plan-v2&envId=top-100-liked"/>
 */
public class _54_spiral_matrix {

    /**
     * 按层遍历模拟，难点在于单行或单列的处理，我这里选择了单独处理
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        List<Integer> ans = new ArrayList<>();
        while (left < right && up < down) {
            for (int i = left; i < right; i++) {
                ans.add(matrix[up][i]);
            }

            for (int i = up; i < down; i++) {
                ans.add(matrix[i][right]);
            }

            for (int i = right; i > left; i--) {
                ans.add(matrix[down][i]);
            }

            for (int i = down; i > up; i--) {
                ans.add(matrix[i][left]);
            }

            left++;
            right--;
            up++;
            down--;
        }

        if (up == down) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[up][i]);
            }
        }
        else if (left == right) {
            for (int i = up; i <= down; i++) {
                ans.add(matrix[i][left]);
            }
        }

        return ans;
    }

}