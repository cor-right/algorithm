package _2025.subjects._16_dp_2d_3;

/**
 * 买卖股票的最佳时机 Ⅱ
 *
 * @author 佳叙
 * @date 2025/4/18
 * @description <a href=""/>
 */
public class _122_best_time_to_buy_and_sell_stocks_2 {

    /**
     * 贪心
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] memo = new int[prices.length + 1][2];
        memo[0][0] = 0;
        memo[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            memo[i][0] = Math.max(memo[i - 1][0], memo[i - 1][1] + prices[i]);
            memo[i][1] = Math.max(memo[i - 1][1], memo[i - 1][0] - prices[i]);
        }

        return memo[prices.length - 1][0];
    }

}