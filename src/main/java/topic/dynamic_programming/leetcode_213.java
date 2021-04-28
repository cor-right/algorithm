package topic.dynamic_programming;

/**
 * 213. 打家劫舍 II
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * time: 2021-04-28
 */
public class leetcode_213 {

    /**
     * dynamic programming
     *
     * the thief can skip one or two house, to steal money.
     * but there is no need to skip three house.
     * because if he skip that house,
     * then the money is always less than that he can steal when he not skip.
     *
     * so we only need to concern the n - 2 and n - 3 house.
     *
     * dynamic programming formula
     * //core    a[n] = max( a[n - 2], a[n - 3] ) + t
     * //return  max( a[n - 1], max(a[n - 2], a[n - 3] + t))
     *
     *
     *
     * the first and the last can not connected, so there are two different solving range
     * // range 1: 0 ~ n - 2
     * // range 2: 1 ~ n - 1
     * @param nums
     * @return
     */
    public int rob(int[] nums) {

        int houseCount = nums.length;

        if (houseCount == 0) {
            return 0;
        }
        if (houseCount == 1) {
            return nums[0];
        }
        if (houseCount == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] maxPriceA = new int[houseCount + 1];
        int[] maxPriceB = new int[houseCount + 1];

        maxPriceA[0] = nums[0];
        maxPriceA[1] = nums[1];
        maxPriceB[0] = nums[0];
        maxPriceB[1] = nums[1];

        for (int i = 2; i < houseCount - 1; i++) {
            maxPriceA[i] = calculateMaxMoneyAmount(maxPriceA, i, 0, nums[i]);
        }
        int firstRountMaxPrice = Math.max(maxPriceA[houseCount - 2], maxPriceA[houseCount - 3]);

        for (int i = 2; i < houseCount; i++) {
            maxPriceB[i] = calculateMaxMoneyAmount(maxPriceB, i, 1, nums[i]);
        }
        int secondRoundMaxPrice = Math.max(maxPriceB[houseCount - 1], maxPriceB[houseCount - 2]);

        return Math.max(firstRountMaxPrice, secondRoundMaxPrice);
    }

    private int calculateMaxMoneyAmount(int[] maxPriceArr, int index, int startIndex, int currentIndexMoney) {
        if (index - 2 < startIndex) {
            return currentIndexMoney;
        }
        if (index - 3 < startIndex) {
            return maxPriceArr[index - 2] + currentIndexMoney;
        }

        return Math.max(maxPriceArr[index - 2], maxPriceArr[index - 3]) + currentIndexMoney;
    }

}
