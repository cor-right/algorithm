package _2025._hot100._20250421;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 分割等和子集
 *
 * @author 佳叙
 * @date 2025/4/21
 * @description <a href="https://leetcode.cn/problems/partition-equal-subset-sum/description/?envType=study-plan-v2&envId=top-100-liked"/>
 */
public class _416_partition_equal_subset_sum {


    /**
     * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;

        boolean[] memo = new boolean[target + 1];
        memo[0] = true;

        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                memo[i] = memo[i] || memo[i - num];
            }
            if (memo[target]) {
                return true;
            }
        }

        return false;
    }

//    public boolean canPartition(int[] nums) {
//        Set<Integer> memo = new HashSet<>();
//        memo.add(0);
//
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int digit = nums[i];
//            sum += nums[i];
//            memo.addAll(memo.stream().map(d -> d + digit).collect(Collectors.toList()));
//        }
//
//        return sum % 2 != 1 && memo.contains(sum / 2);
//    }

}
