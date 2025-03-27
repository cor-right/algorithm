package _2025._hot100._20250327;

/**
 * 多数元素
 *
 * @author 佳叙
 * @date 2025/3/27
 * @description <a href="https://leetcode.cn/problems/majority-element/description/"/>
 */
public class _169_majority_element {

    /**
     * 同归于尽
     */
    public int majorityElement(int[] nums) {
        int num = nums[0];
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                num = nums[i];
                cnt = 1;
                continue;
            }

            cnt = num == nums[i] ? cnt + 1 : cnt - 1;
        }

        return num;
    }

}