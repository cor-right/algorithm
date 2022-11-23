package offer.day4;

/**
 * @code https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=108mt86
 *
 * 剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 *
 * [0, 1, 2/2, 3/3, null, 5, null]
 * 输出：2 或 3
 *
 *
 * 限制：
 *
 * 2 <= n <= 100000
 */
public class Offer03 {

    /**
     * 双循环？ x ，100000 会超时
     *
     * 哈希表？
     *
     * 原地交换，使下标和数字一一对齐。i是递增，但是每次都可能进行很多次交换。
     *
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {



        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }

            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }

            int t = nums[i];
            nums[i] = nums[t];
            nums[t] = t;
        }
        return -1;
    }

//    public static void main(String[] args) {
//        System.out.println(findRepeatNumber(new int []{2, 1, 3, 2}));
//    }



}
