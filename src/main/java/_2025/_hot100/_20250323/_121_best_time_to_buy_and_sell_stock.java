package _2025._hot100._20250323;

/**
 * 买卖股票的最佳时机
 *
 * @author 佳叙
 * @date 2025/3/23
 * @description <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/"/>
 */
public class _121_best_time_to_buy_and_sell_stock {

    /**
     * Record before min.
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return max;
    }

}