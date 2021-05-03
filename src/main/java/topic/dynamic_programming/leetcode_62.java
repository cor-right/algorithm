package topic.dynamic_programming;

/**
 * 62. Unique Paths
 * Medium
 *
 * 5033
 *
 * 246
 *
 * Add to List
 *
 * Share
 * A robot is located at the top-left corner of a m - n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 *
 *
 * Example 1:
 *
 *
 * Input: m = 3, n = 7
 * Output: 28
 * Example 2:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 * Example 3:
 *
 * Input: m = 7, n = 3
 * Output: 28
 * Example 4:
 *
 * Input: m = 3, n = 3
 * Output: 6
 *
 * 1 <= m, n <= 100
 * It's guaranteed that the answer will be less than or equal to 2 * 10^9.
 */
public class leetcode_62 {

    /**
     * m is row num, n is col num
     *
     * dynamic programming equation:
     *     a[m][n] = f(a[m - 1][n] + a[m][n - 1]);
     *
     * m is the col num, form left to right marked as 0 to max
     * n is the row num, form top to down marked as 0 to max
     *
     * Integer is satisfied the range requirement.
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dpRecord = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dpRecord[i][j] = dpFunction(dpRecord, i, j);
            }
        }
        return dpRecord[m - 1][n - 1];
    }

    private int dpFunction(int[][] dpRecord, int i, int j) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i - 1 < 0) {
            return dpRecord[i][j - 1];
        }
        if (j - 1 < 0) {
            return dpRecord[i - 1][j];
        }

        return dpRecord[i][j] = dpRecord[i - 1][j] + dpRecord[i][j - 1];
    }

}
