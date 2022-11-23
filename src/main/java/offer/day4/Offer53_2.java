package offer.day4;

/**
 * @code https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=108mt86
 *
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 10000
 */
public class Offer53_2 {

    /**
     * 下标与数字不一致的第一个位置，就是对应的数字，下标和数组不对应就是了
     *
     * 二分查找的最终结果
     *
     * i 0 ~ nums.length
     * j -1 ~ nums.length - 1
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {

        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (mid < nums[mid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return i;


    }

}
