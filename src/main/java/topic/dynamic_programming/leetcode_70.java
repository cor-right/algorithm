package topic.dynamic_programming;

public class leetcode_70 {

    // dp easy

    // a[n] = a[n-1] + a[n-2]

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
