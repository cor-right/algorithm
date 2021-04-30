package topic.dynamic_programming;

/**
 * 198. 打家劫舍
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * time: 2021-04-24
 */
public class leetcode_198 {

    //

    // a[n] = max( a[n - 2], a[n - 3] ) + t

    // same as a[n] = max(a [n - 2] + t, a[n - 1])

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
