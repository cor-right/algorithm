package _2025.subjects._14_dp_2d;

/**
 * 不同路径
 *
 * @author 佳叙
 * @date 2025/4/11
 * @description <a href="https://leetcode.cn/problems/unique-paths/"/>
 */
public class _62_unique_paths {

    /**
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m + 1][n + 1];
        memo[1][1] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                memo[i][j] += memo[i - 1][j];
                memo[i][j] += memo[i][j - 1];
            }
        }

        return memo[m][n];
    }

}