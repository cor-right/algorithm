package topic.dynamic_programming;

/**
 * 413. Arithmetic Slices
 * An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 *
 * For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
 * Given an integer array nums, return the number of arithmetic subarrays of nums.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: 3
 * Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 *
 */
public class leetcode_413 {

    /**
     * 虽然用DP解，但使用排列组合的方式更精巧。
     *
     * 排列组合，排的是等差数列长度>=3的部分的排列数，比如 1, 2, 3, 4，其差为 1， 1， 1， 相同差数量>=2的时候，代表等差数列
     * 的长度>=3，此时可以进行排列。
     *
     * 于是可以将1, 1, 1，排列成 (1, 1), 1、1, (1, 1), (1, 1, 1) 三种，由于等差数量最少三个元素，
     * 所以差值最少两个1为一组，此时排列的元素共两个，所以
     * 套用公式，x 为差值数量 = 2，排列数为 x(x+1)/2 = 3
     *
     * 又因为1, 1, 1本质上是 1, 2, 3, 4，比如(1, 1), 1，本质上排列的是 1, 2, 3, 4，可以看到x的值应当是真实数据的数量-2
     *
     * 公式就变成了 (x-2)(x-1)/2 =3
     *
     * (1+2+3+...+(n-2))=(n-1)(n-2)/2
     */

    /**
     * 当等差数列长度加1，则其所增加的排列数，是前一个排列基础上，
     * 增加从尾部开始，长度分别为 3~(tail-head-1) 的数目的排列。
     *
     * a[m] = a[m - 1] + m - 1;
     *
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }

        int[] dpRecord = new int[nums.length + 1];

        for (int i = 1; i < nums.length; i++) {
            dpRecord[i] = dpFunction(dpRecord, nums, i);
        }
        return result;
    }

    int head = 0;
    int tail = 0;
    int difference = 0;
    int result = 0;

    private int dpFunction(int[] dpRecord, int[] nums, int index) {
        if (index == 1) {
            tail = 1;
            difference = nums[1] - nums[0];
            return 0;
        }

        tail = index;
        int currentDifference = nums[index] - nums[index - 1];
        if (currentDifference != difference) {
            head = index - 1;
            difference = currentDifference;
            return 0;
        }

        int seqLen = tail - head;
        if (seqLen >= 2) {
            result += (seqLen - 1);
            return dpRecord[index - 1] + seqLen - 1;
        }
        else {
            return 0;
        }
    }

}
