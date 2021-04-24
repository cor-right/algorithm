package topic.dynamic_programming;

public class leetcode_198 {

    // DP medium

    // a[n] = max( a[n - 2], a[n - 3] ) + t

    public int rob(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int houseCount = prices.length;

        if (houseCount == 1) {
            return prices[0];
        }
        if (houseCount == 2) {
            return Math.max(prices[1], prices[0]);
        }
        if (houseCount == 3) {
            return Math.max(prices[1], prices[0] + prices[2]);
        }

        int[] maxPrices = new int[houseCount + 3];

        maxPrices[0] = prices[0];
        maxPrices[1] = prices[1];
        maxPrices[2] = Math.max(maxPrices[1], prices[0] + prices[2]);

        for(int i = 3; i < houseCount; i++) {
            maxPrices[i] = calMaxPrices(i, maxPrices, prices[i]);
        }

        return Math.max(maxPrices[houseCount - 1], maxPrices[houseCount - 2]);
    }

    // for example house 3, maxPrices[2] = max( [2 - 2], 0 ) + prices[3]
    private int calMaxPrices(int index, int[] maxPrices, int currentIndexPrice) {
        return Math.max(maxPrices[index - 2], maxPrices[index - 3]) + currentIndexPrice;
    }

}
