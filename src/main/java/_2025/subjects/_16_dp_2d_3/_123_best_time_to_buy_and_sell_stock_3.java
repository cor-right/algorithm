package _2025.subjects._16_dp_2d_3;

/**
 * 买卖股票的最佳时机 Ⅲ
 *
 * @author 佳叙
 * @date 2025/4/20
 * @description <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/"/>
 */
public class _123_best_time_to_buy_and_sell_stock_3 {

    /**
     *
     *
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * O (n^2)：
     * O (n)：
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] profits = new int[prices.length + 1][2];

        for (int i = 1; i < prices.length; i++) {
            profits[i][0] = profits[i - 1][0];
            profits[i][1] = profits[i - 1][1];

            for (int j = 0; j < i; j++) {
                profits[i][0] = Math.max(profits[i][0], prices[i] - prices[j]);
                profits[i][1] = Math.max(profits[i][1], profits[j][0] + prices[i] - prices[j]);
            }
        }

        return Math.max(profits[prices.length - 1][0], profits[prices.length - 1][1]);
    }

    /**
     * Using variable record best profit.
     *
     * For each day, there are five type of action.
     * - Do nothing.
     * - Buy
     * - Sell
     * - Buy again
     * - Sell again
     *
     * For each action, consulting best profits.
     *
     * @param prices
     * @return
     */
    private int maxProfitOn(int[] prices) {
        // 0: buy
        // 1: sell
        // 2: buy again
        // 3: sell again

        int[][] memo = new int[prices.length][4];
        memo[0][0] = -prices[0];
        memo[0][2] = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {
            memo[i][0] = Math.max(memo[i - 1][0], -prices[i]);
            memo[i][1] = Math.max(memo[i - 1][1], memo[i - 1][0] + prices[i]);
            memo[i][2] = Math.max(memo[i - 1][2], memo[i - 1][1] - prices[i]);
            memo[i][3] = Math.max(memo[i - 1][3], memo[i - 1][2] + prices[i]);
        }

        return Math.max(0, Math.max(memo[prices.length - 1][1], memo[prices.length - 1][3]));
    }

}