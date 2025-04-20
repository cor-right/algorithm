package _2025.subjects._16_dp_2d_3.stock;

/**
 * 买卖股票的最佳时期含冷冻期
 *
 * @author 佳叙
 * @date 2025/4/20
 * @description <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/"/>
 */
public class _309_best_time_to_buy_and_sell_stock_with_cooldown {

    /**
     * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 状态：
     * 状态转移：
     *
     * 1 <= prices.length <= 5000
     * 0 <= prices[i] <= 1000
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // 0: Buy
        // 1: Sell
        int[][] memo = new int[prices.length][2];
        memo[0][0] = -prices[0];
        memo[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            memo[i][0] = Math.max(memo[i - 1][0], memo[i - (i > 1 ? 2 : 1)][1] - prices[i]);
            memo[i][1] = Math.max(memo[i - 1][1], memo[i - 1][0] + prices[i]);
        }

         return memo[prices.length - 1][1];
    }

}