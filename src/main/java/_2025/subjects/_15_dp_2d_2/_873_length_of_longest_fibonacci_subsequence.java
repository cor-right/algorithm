package _2025.subjects._15_dp_2d_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 最长的斐波那契子序列长度
 *
 * @author 佳叙
 * @date 2025/4/14
 * @description <a href="https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/"/>
 */
public class _873_length_of_longest_fibonacci_subsequence {

    /**
     * 子问题：子序列内部的斐波那契长度
     *
     * 表现形式：memo[i][j] 作为子序列，i、j 是序列末尾的两个元素，dp[i][j]：表示以A[i],A[j]结尾的斐波那契数列的最大长度
     * 获取子序列：需要循环，逐个确认子序列，获取其长度
     *
     * 重点在于状态定义，状态定义，这里的状态定义是末尾的两个元素，而不是区间范围！！！！
     *
     * @param arr
     * @return
     */
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            indexMap.put(arr[i], i);
        }

        int max = 0;
        int[][] memo = new int[arr.length][arr.length];
        for (int i = 2; i < arr.length; i++) {
            for (int r = i - 1; r >= 0 && arr[i] - arr[r] < arr[r]; r--) {
                Integer l = indexMap.get(arr[i] - arr[r]);
                if (l != null) {
                    max = Math.max(max, memo[r][i] = Math.max(memo[r][i], memo[l][r] + 1));
                }
            }
        }

        return max == 0 ? 0 : max + 2;
    }

}