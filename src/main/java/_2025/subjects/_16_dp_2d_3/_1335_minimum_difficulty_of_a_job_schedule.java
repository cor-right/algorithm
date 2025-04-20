package _2025.subjects._16_dp_2d_3;

import java.util.Arrays;

/**
 * 工作计划的最低难度
 *
 * @author 佳叙
 * @date 2025/4/20
 * @description <a href="https://leetcode.cn/problems/minimum-difficulty-of-a-job-schedule/"/>
 */
public class _1335_minimum_difficulty_of_a_job_schedule {

    /**
     *
     * 你需要制定一份 d 天的工作计划表。工作之间存在依赖，要想执行第 i 项工作，你必须完成全部 j 项工作（ 0 <= j < i）。
     * 你每天 至少 需要完成一项任务。工作计划的总难度是这 d 天每一天的难度之和，而一天的工作难度是当天应该完成工作的最大难度。
     * 给你一个整数数组 jobDifficulty 和一个整数 d，分别代表工作难度和需要计划的天数。第 i 项工作的难度是 jobDifficulty[i]。
     * 返回整个工作计划的 最小难度 。如果无法制定工作计划，则返回 -1 。
     *
     * K 组，每组的最大值构成的和最小
     *
     * 子问题：
     * K - 1 组，前 N 个数
     *
     * 边界：
     * 1 <= jobDifficulty.length <= 300
     * 0 <= jobDifficulty[i] <= 1000
     * 1 <= d <= 10
     *
     * 优化：
     * 组内最大值：迭代的算
     *
     * @param jobDifficulty
     * @param d
     * @return
     */
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) {
            return -1;
        }

        int[][] memo = new int[d][jobDifficulty.length];

        memo[0][0] = jobDifficulty[0];
        for (int i = 1; i < jobDifficulty.length; i++) {
            memo[0][i] = Math.max(memo[0][i - 1], jobDifficulty[i]);
        }

        for (int i = 1; i < d; i++) {
            for (int j = i; j < jobDifficulty.length; j++) {
                memo[i][j] = 99999;

                int max = 0;
                for (int k = j; k >= i; k--) {
                    max = Math.max(max, jobDifficulty[k]);
                    memo[i][j] = Math.min(memo[i][j], max + memo[i - 1][k - 1]);
                }
            }
        }

        return memo[d - 1][jobDifficulty.length - 1];
    }

}