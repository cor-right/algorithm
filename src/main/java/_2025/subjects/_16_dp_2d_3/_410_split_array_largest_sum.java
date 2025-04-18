package _2025.subjects._16_dp_2d_3;

/**
 * 分割数组的最大值
 *
 * 如果是连续区间，那么在缩减子问题的时候，可以使用单指针，进行单向扩展来维护区间。本题中就可以将数组的 nums[0] 作为左边界固定不变，调整右边界。
 *
 * @author 佳叙
 * @date 2025/4/17
 * @description <a href="https://leetcode.cn/problems/split-array-largest-sum/description/"/>
 */
public class _410_split_array_largest_sum {

    /**
     * 这个题和 301 题 break_words 有点类似，都是在最后一个元素确定的基础上，寻找其他元素的最优情况
     *
     * 子问题：前 n 个元素的 k - 1 组的最大值
     * 状态定义：memo[组数][前n个元素的数量]
     * 状态转移：memo[cnt][i] = Math.min(memo[cnt][i], Math.max(memo[cnt - 1][j], prefixes[i] - prefixes[j]));
     *
     * 当然这个题我觉得用二分查找做是更好的
     *
     * @param nums
     * @param k
     * @return
     */
    public int splitArray(int[] nums, int k) {
        return splitArrayWithLoop(nums, k);
//        return splitArrayWithRecursion(nums, k);
    }

    private int splitArrayWithLoop(int[] nums, int k) {

        int[] prefixes = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixes[i + 1] = prefixes[i] + nums[i];
        }

        int[][] memo = new int[k + 1][nums.length + 1];
        System.arraycopy(prefixes, 0, memo[1], 0, prefixes.length);

        for (int cnt = 2; cnt <= k; cnt++) {
            for (int i = cnt; i <= nums.length; i++) {
                memo[cnt][i] = Integer.MAX_VALUE;

                for (int j = cnt - 1; j < i; j++) {
                    memo[cnt][i] = Math.min(memo[cnt][i], Math.max(memo[cnt - 1][j], prefixes[i] - prefixes[j]));
                }
            }
        }

        return memo[k][nums.length];
    }

    private int splitArrayWithRecursion(int[] nums, int k) {
        int[] prefixes = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixes[i + 1] = prefixes[i] + nums[i];
        }

        return recursion(nums, prefixes, new Integer[nums.length + 1][k + 1], k, nums.length);
    }

    /**
     *
     * @param nums
     * @param prefixes
     * @param memo  状态数组，row 是前 n 个元素， col 是组数，memo[n][k] 就是用前 n 个元素生成的 k 个子序列的和的最小值
     * @param k     组数
     * @param n     nums中，用于生成 k 组子序列的前 N 个元素
     * @return
     */
    private int recursion(int[] nums, int[] prefixes, Integer[][] memo, int k, int n) {
        if (k > n) {
            return 2147483647;
        }

        if (memo[n][k] != null) {
            return memo[n][k];
        }

        if (k == 1) {
            return memo[n][k] = prefixes[n] - prefixes[0];
        }

        int minSum = 2147483647;
        for (int i = 0; i < n; i++) {
            minSum = Math.min(minSum, Math.max(recursion(nums, prefixes, memo, k - 1, i), prefixes[n] - prefixes[i]));
        }

        memo[n][k] = minSum;
        return minSum;
    }

}