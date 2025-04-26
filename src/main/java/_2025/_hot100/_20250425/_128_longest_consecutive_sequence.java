package _2025._hot100._20250425;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 最长连续序列
 *
 * @author 佳叙
 * @date 2025/4/26
 * @description <a href=""/>
 */
public class _128_longest_consecutive_sequence {

    /**
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        set.addAll(IntStream.of(nums).boxed().collect(Collectors.toList()));

        int ans = 0;
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }

            int tail = num;
            while (set.contains(tail)) {
                tail++;
            }

            ans = Math.max(ans, tail - num - 1);
        }

        return ans;
    }

}