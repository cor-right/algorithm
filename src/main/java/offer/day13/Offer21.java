package offer.day13;

/**
 * @code https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=108mt86
 *
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 50000
 * 0 <= nums[i] <= 10000
 */
public class Offer21 {

    public int[] exchange(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            while (i < j && nums[i] % 2 == 1) {
                i++;
            }
            while (i < j && nums[j] % 2 == 0) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        return nums;
    }

}
