package offer2;

/**
 * @code https://leetcode.cn/problems/xoh6Oh/?favorite=e8X3pBZi
 *
 * 剑指 Offer II 001. 整数除法
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 *
 *
 *
 * 注意：
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231−1]。本题中，如果除法结果溢出，则返回 231 − 1
 *
 *
 * 示例 1：
 *
 * 输入：a = 15, b = 2
 * 输出：7
 * 解释：15/2 = truncate(7.5) = 7
 * 示例 2：
 *
 * 输入：a = 7, b = -3
 * 输出：-2
 * 解释：7/-3 = truncate(-2.33333..) = -2
 * 示例 3：
 *
 * 输入：a = 0, b = 1
 * 输出：0
 * 示例 4：
 *
 * 输入：a = 1, b = 1
 * 输出：1
 *
 *
 * 提示:
 *
 * -231 <= a, b <= 231 - 1
 * b != 0
 *
 */
public class Offer2_001 {

    /**
     * ">>" == "/2"
     *
     * 除法使用减法替代
     *
     * @param a
     * @param b
     * @return
     */
    public int divide(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }



        if (b == Integer.MIN_VALUE) {
            return a == b ? 1 : 0;
        }

        int result = 0;
        if (a == Integer.MIN_VALUE) {
            if (b == -1) {
                return Integer.MAX_VALUE;
            } else if (b > 0){
                a = a + b;
                result++;
            } else {
                a = a - b;
                result++;
            }
        }

        boolean unsign = a > 0 == b > 0;
        a = Math.abs(a);
        b = Math.abs(b);


        // core
        for (int i = 31; i >= 0; i--) {
            if ((a >>> i) - b >= 0) {
                a = a - (b << i);
                result += (1 << i);
            }


        }

        return unsign ? -result : result;
    }

}
