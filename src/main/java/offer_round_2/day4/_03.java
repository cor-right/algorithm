package offer_round_2.day4;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 *
 * 限制：
 *
 * 2 <= n <= 100000
 *
 * 通过次数727,114提交次数1,081,913
 */
public class _03 {

    /**
     * 1. hash table : easy
     * 2. in-situ exchange : more difficult, saving more memory
     *
     * use 2
     *
     * exchange current number with the same index
     *
     * Time complexity : O(n)
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) {
                continue;
            }

            while (nums[i] != i) {
                int targetNum = nums[nums[i]];
                if (targetNum == nums[i]) {
                    return targetNum;
                }

                nums[nums[i]] = nums[i];
                nums[i] = targetNum;
            }
        }
        return -1;
    }

}
