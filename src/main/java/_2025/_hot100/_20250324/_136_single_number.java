package _2025._hot100._20250324;

/**
 * 只出现一次的数字
 *
 * @author 佳叙
 * @date 2025/3/24
 * @description <a href="https://leetcode.cn/problems/single-number/description/"/>
 */
public class _136_single_number {

    /**
     * 位运算
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num ^= nums[i];
        }
        return num;
    }

}