package _2025._hot100._20250323;

/**
 * 买卖股票的最佳时机 II
 *
 * @author 佳叙
 * @date 2025/3/23
 * @description <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/"/>
 */
public class _122_best_time_to_buy_and_sell_stock_2 {

    /**
     * Dynamic planning.
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] profit = new int[prices.length][2];

        profit[0][0] = 0;
        profit[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            profit[i][0] = Math.max(profit[i - 1][0], profit[i - 1][1] + prices[i]);
            profit[i][1] = Math.max(profit[i - 1][0] - prices[i], profit[i - 1][1]);
        }

        return profit[prices.length - 1][0];
    }



}