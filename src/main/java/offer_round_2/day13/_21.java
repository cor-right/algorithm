package offer_round_2.day13;

/**
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
 * 通过次数363,163提交次数558,744
 */
public class _21 {

    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            if (left != right) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }
        }

        return nums;
    }

}
