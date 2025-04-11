package _2025.subjects._13_dp_1d;

/**
 * @author 佳叙
 * @date 2025/4/11
 * @description <a href="https://leetcode.cn/problems/counting-bits/"/>
 */
public class _338_counting_bits {

    /**
     * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
     *
     * <p>
     *     Brian Kernighan 算法的原理是：对于任意整数 x，令 x=x & (x−1)，该运算将 x 的二进制表示的最后一个 1 变成 0。
     *     动态规划：最高有效位
     *     动态规划：最低有效位
     *     动态规划：最低设置位，运用Brian Kernighan 将最后一位变为0的特性，缩小空间
     * </p>
     *
     * <p>
     *     子问题：更小的数字
     *     状态转移：
     * </p>
     *
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        return countBitsWithRemoveLastOne(n);
    }

    /**
     * 最高有效位，最高的1一定是2的倍数，将该数字提取出来，并取剩余数字的memo，就可以利用子问题
     *
     * <p>
     *      输入：n = 5
     *      输出：[0,1,1,2,1,2]
     *      解释：
     *      0 --> 0   -> 0
     *      1 --> 1   -> 1
     *      2 --> 10  -> 2
     *      3 --> 11  -> 2 + 1
     *      4 --> 100 -> 4
     *      5 --> 101 -> 4 + 1
     *      6 --> 110 -> 4 + 2     -> 1 + a[2]
     *      7 --> 111 -> 4 + 2 + 1 -> 1 + a[3]
     *      8 --> 1000
     * </p>
     *
     * @param n
     * @return
     */
    private int[] countBitsWithMaximum(int n) {
        int top = 1;

        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i == top * 2) {
                top = top * 2;
            }

            ans[i] = 1 + ans[i - top];
        }

        return ans;
    }

    /**
     * 最低有效位，通过向右移位，可以使数字变小，进而利用子问题
     *
     * <p>
     *
     * </p>
     *
     * @param n
     * @return
     */
    private int[] countBitsWithMinimum(int n) {
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            ans[i] = i % 2 == 1 ? ans[i >> 1] + 1 : ans[i >> 1];
        }

        return ans;
    }

    /**
     * 将最后一位1设置为0，来实现降低问题规模
     *
     * @param n
     * @return
     */
    private int[] countBitsWithRemoveLastOne(int n) {
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }

        return ans;
    }


}