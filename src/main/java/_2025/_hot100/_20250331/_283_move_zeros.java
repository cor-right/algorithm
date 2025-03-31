package _2025._hot100._20250331;

/**
 * 移动零
 *
 * <p>
 *     给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *     请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *      输入: nums = [0,1,0,3,12]
 *      输出: [1,3,12,0,0]
 * </p>
 *
 * @author 佳叙
 * @date 2025/3/31
 * @description <a href="https://leetcode.cn/problems/move-zeroes/description/"/>
 */
public class _283_move_zeros {

    /**
     * Pointer.
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int fast = 0;
        int slow = 0;

        while (fast < nums.length) {
            if (nums[fast] != 0) {
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
            fast++;
        }
    }

}