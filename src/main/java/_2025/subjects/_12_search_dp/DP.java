package _2025.subjects._12_search_dp;

/**
 *
 * DP: 也被称为 Search + Memoization
 * 如果 Search Space 中存在重复子问题的话，可以记录下这些子问题的答案来保证不会重复计算多次。时间复杂度取决于子问题的个数
 *
 * 所有 DP 都可以写成 Bottom Up DFS.
 * 1. 重中之重是定义好状态
 * 2. 定义好状态后，可以从一个中间状态出发，去思考递归规则
 *
 *
 * @author 佳叙
 * @date 2025/4/7
 * @description <a href=""/>
 */
public class DP {


    public void template() {
        // 1. Define STATE of sub problems.
        // 2. Initialize memo to record calculated sub problems.
        // 3. Return DFS (top_level_answer_state).

        // DFS
        // 1. Base case check.
        // 2. If current problem is calculated, return its answer.
        // 3. For each problem.
            // a. Ask sub problems for their answer -> call DFS(sub problem state).
            // b. Build up current state problem answer based on sub problem answers.
        // 4. Store current problem answer.

    }
}