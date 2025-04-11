package _2025.subjects._14_dp_2d;

/**
 * 不同路径 Ⅱ
 *
 * @author 佳叙
 * @date 2025/4/11
 * @description <a href="https://leetcode.cn/problems/unique-paths-ii/description/"/>
 */
public class _63_unique_paths_2 {

    /**
     *
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] memo = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        memo[1][1] = 1;

        for (int i = 1; i <= obstacleGrid.length; i++) {
            for (int j = 1; j <= obstacleGrid[0].length; j++) {
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    memo[i][j] = 0;
                } else {
                    memo[i][j] += memo[i - 1][j] + memo[i][j - 1];
                }
            }
        }

        return memo[obstacleGrid.length][obstacleGrid[0].length];
    }



}