package _2025._hot100._20250425;

import java.util.Arrays;

/**
 * 跳跃游戏 Ⅱ
 *
 * @author 佳叙
 * @date 2025/4/26
 * @description <a href=""/>
 */
public class _45_jump_game_2 {

    /**
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j <= nums[i] && i + j <= nums.length - 1; j++) {
                memo[i + j] = Math.min(memo[i + j], memo[i] + 1);
            }
        }

        return memo[nums.length - 1];
    }

}