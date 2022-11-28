package offer.day9;

/**
 * @code https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=108mt86
 *
 * 剑指 Offer 47. 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
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
 */
public class Offer47 {

    /**
     * 决策是 → 或 ↓
     *
     * dp[1][1] = Math.max(dp[0][1], dp[1][0]) + grid[1][1];
     *
     * 期间注意边界
     *
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int dpUp = i > 0 ? dp[i - 1][j] : 0;
                int dpLeft = j > 0 ? dp[i][j - 1] : 0;
                dp[i][j] = Math.max(dpUp, dpLeft) + grid[i][j];
            }
        }

        return dp[grid.length - 1][grid[0].length -1];
    }


}
