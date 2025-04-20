package _2025.subjects._16_dp_2d_3.stock;

/**
 * 买卖股票的最佳时机含手续费
 *
 * @author 佳叙
 * @date 2025/4/20
 * @description <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/"/>
 */
public class _714_best_time_to_buy_and_sell_stock_with_transaction_fee {

    /**
     * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。返回获得利润的最大值。
     * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     *
     * 1 <= prices.length <= 5 * 10^4
     * 1 <= prices[i] < 5 * 10^4
     * 
     * 这个数据范围，就考虑 O(n) 算法吧，手续费放在卖出的时候处理吧，因为要赚钱，最后肯定是要卖出的
     * 
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        // 0: Buy
        // 1: Sell, reduce fee
        int[][] memo = new int[prices.length][2];
        memo[0][0] = -prices[0];
        memo[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            memo[i][0] = Math.max(memo[i - 1][0], memo[i - 1][1] - prices[i]);
            memo[i][1] = Math.max(memo[i - 1][1], memo[i - 1][0] + prices[i] - fee);
        }

        return memo[prices.length - 1][1];

    }

}