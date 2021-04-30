package topic.dynamic_programming;

/**
 * 70. 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * time: 2021-04-24
 */
public class leetcode_70 {

    //

    // a[n] = a[n-1] + a[n-2]

    /**
     * dynamic programming
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        int[] stepCountArr = new int[n + 2];

        stepCountArr[0] = 0;
        stepCountArr[1] = 1;
        stepCountArr[2] = 2;

        //

        for (int i  = 3; i <= n; i++) {
            stepCountArr[i] = calStepCount(i, stepCountArr);
        }

        return stepCountArr[n - 1];
    }

    private int calStepCount(int n, int[] stepCountArr) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return stepCountArr[n - 1] + stepCountArr[n - 2];
    }

}
