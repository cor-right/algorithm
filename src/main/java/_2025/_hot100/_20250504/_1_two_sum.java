package _2025._hot100._20250504;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 佳叙
 * @date 2025/5/4
 * @description <a href=""/>
 */
public class _1_two_sum {

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>();

        Integer pre;
        for (int i = 0; i < nums.length; i++) {
            if ((pre = memo.get(target - nums[i])) != null) {
                return new int[] {pre, i};
            }
            memo.put(nums[i], i);
        }

        return null;
    }

}