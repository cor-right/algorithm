package _2025._hot100._20250423;

/**
 * @author 佳叙
 * @date 2025/4/23
 * @description <a href="https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked"/>
 */
public class _283_move_zeroes {

    /**
     * 移动零
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
            }

            fast++;
        }
    }

}