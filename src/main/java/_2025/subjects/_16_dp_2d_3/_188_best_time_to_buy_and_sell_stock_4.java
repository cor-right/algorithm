package _2025.subjects._16_dp_2d_3;

/**
 * 买卖股票的最佳实践 Ⅳ
 *
 * @author 佳叙
 * @date 2025/4/17
 * @description <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/description/"/>
 */
public class _188_best_time_to_buy_and_sell_stock_4 {

    /**
     * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length / 2) {
            return maxProfitForBigger(k, prices);
        } else {
            return maxProfitForSmaller(k, prices);
        }
    }

    /**
     * K >= n / 2 时，每天都可以交易，买卖股票的最佳实践 Ⅱ，直接贪心，升了就买
     *
     * @param k
     * @param prices
     * @return
     */
    private int maxProfitForBigger(int k, int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }

        return profit;
    }

    /**
     * 子问题是：更小的区间和更小的交易次数
     *
     * @param times
     * @param prices
     * @return
     */
    private int maxProfitForSmaller(int times, int[] prices) {
        int[][] memo = new int[times + 1][prices.length + 1];

        for (int cnt = 1; cnt <= times; cnt++) {

            for (int i = 1; i <= prices.length; i++) {
                memo[cnt][i] = memo[cnt][i - 1];

                for (int j = 1; j < i; j++) {
                    memo[cnt][i] = Math.max(memo[cnt][i], memo[cnt - 1][j] + prices[i - 1] - prices[j - 1]);
                }
            }
        }

        return memo[times][prices.length];
    }

}