package offer_round_2.day9;

/**
 * 剑指 Offer 47. 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 *
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 *
 * 提示：
 *
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 * 通过次数264,422提交次数380,833
 */
public class _47 {

    public int maxValue(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int[][] dp = new int[grid.length][grid[0].length];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                dp[row][col] = Math.max(row == 0 ? 0 : dp[row - 1][col], col == 0 ? 0 : dp[row][col - 1]) + grid[row][col];
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }

}
