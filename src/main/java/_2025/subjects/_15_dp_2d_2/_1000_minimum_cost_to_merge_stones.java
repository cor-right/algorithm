package _2025.subjects._15_dp_2d_2;

import java.util.Arrays;

/**
 * 石头合成的最低成本
 *
 * @author 佳叙
 * @date 2025/4/15
 * @description <a href=""/>
 */
public class _1000_minimum_cost_to_merge_stones {

    /**
     *
     * 子问题：更少数量的石堆，成本是不断累加的，
     *
     *
     *
     * @param stones
     * @param k
     * @return
     */
    public int mergeStones(int[] stones, int k) {
        if ((stones.length - 1) % (k - 1) != 0) {
            return -1;
        }

        int[] prefix = new int[stones.length + 1];
        for (int i = 0; i < stones.length; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }

        // The cost of sub range.
        int[][] memo = new int[stones.length][stones.length];
        for (int[] ints : memo) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        for (int i = 0; i < stones.length; i++) {
            memo[i][i] = 0;
        }

        for (int len = 2; len <= stones.length; len++) {

            for (int i = 0; i <= stones.length - len; i++) {
                int j = i + len - 1;

                // Traversal all possible split points.
                for (int m = i; m < j; m += (k - 1)) {
                    memo[i][j] = Math.min(memo[i][j], memo[i][m] + memo[m + 1][j]);
                }

                if ((len - 1) % (k - 1) == 0) {
                    memo[i][j] += (prefix[j + 1] - prefix[i]);
                }
            }
        }

        return memo[0][stones.length - 1];
    }



}