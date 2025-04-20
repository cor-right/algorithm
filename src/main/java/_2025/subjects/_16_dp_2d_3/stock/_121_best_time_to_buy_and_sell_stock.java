package _2025.subjects._16_dp_2d_3.stock;

/**
 * 买卖股票的最佳时机
 *
 * @author 佳叙
 * @date 2025/4/20
 * @description <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/"/>
 */
public class _121_best_time_to_buy_and_sell_stock {

    /**
     * 简简单单双指针
     *
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit = 0;

        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return profit;
    }

}