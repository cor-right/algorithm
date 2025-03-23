package _2025._hot100._20250323;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 佳叙
 * @date 2025/3/23
 * @description <a href="https://leetcode.cn/problems/maximal-rectangle/description/"/>
 */
public class _85_maximal_regtangle {

    /**
     * Method one: increment stack.
     * Method two: dynamic planning.
     *
     * @param matrix
     * @return
     */
    public static int maximalRectangle(char[][] matrix) {

        int[][] heights = new int[matrix.length][matrix[0].length + 2];

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) {
                    heights[i][j + 1] = matrix[i][j] - '0';
                }
                else if (matrix[i][j] == '0'){
                    heights[i][j + 1] = 0;
                }
                else {
                    heights[i][j + 1] = heights[i - 1][j + 1] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < heights.length; i++) {

            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < heights[0].length; j++) {
                while (!stack.isEmpty() && heights[i][stack.peek()] > heights[i][j]) {
                    int current = stack.pop();
                    max = Math.max(max, heights[i][current] * (j - stack.peek() - 1));
                }
                stack.push(j);
            }
        }

        return max;

    }

    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][] {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '0', '0'}}));
    }

}