package topic.dynamic_programming;

/**
 * 64. 最小路径和
 *
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-Sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * time: 2021-04-28
 */
public class leetcode_64 {

    /**
     * dynamic programming
     *
     *
     * a[n][m] = Math.max(a[n - 1][m], a[n][m - 1])
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int colLen = grid.length;
        int rowLen = grid[0].length;

        int minSum[][] = new int[colLen + 1][rowLen + 1];

        for (int i = 0; i < colLen; i++) {
            for (int j = 0; j < rowLen; j++) {
                minSum[i][j] = calculateMinSum(i, j, minSum, grid);
            }
        }

        return minSum[colLen - 1][rowLen - 1];
    }

    private int calculateMinSum(int colIndex, int rowIndex, int[][] minSum, int[][] grid) {
        if (colIndex == 0 && rowIndex == 0) {
            return grid[0][0];
        }
        if (colIndex == 0) {
            return minSum[colIndex][rowIndex - 1] + grid[colIndex][rowIndex];
        }
        if (rowIndex == 0) {
            return minSum[colIndex - 1][rowIndex] + grid[colIndex][rowIndex];
        }

        return Math.min(minSum[colIndex][rowIndex - 1], minSum[colIndex - 1][rowIndex]) + grid[colIndex][rowIndex];
    }

}
