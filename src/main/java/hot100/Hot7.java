package hot100;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 *  
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 *  
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class Hot7 {

    /**
     * 字符串反转
     *
     * 栈
     *
     * 数学
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {

        if (x == 0) {
            return 0;
        }

        int unsignResult = 0;
        while (x != 0) {
            int left = x % 10;
            x /= 10;


            if (left > 0) {
                if ((Integer.MAX_VALUE - left) / 10 < unsignResult) {
                    return 0;
                }
            } else {
                if ((Integer.MIN_VALUE - left) / 10 > unsignResult) {
                    return 0;
                }
            }

            unsignResult = unsignResult * 10 + left;
        }

        return unsignResult;

    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

}
