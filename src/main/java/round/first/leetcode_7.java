package round.first;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * time: 2021-05-03
 */
public class leetcode_7 {

    /**
     * result = (result * 10) + (x % 10);
     * x /= 10;
     *
     * long 存储中间结果避免溢出，如果本身结果集用long 那就把溢出判断放在循环中即可。
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }

        long result = 0;
        long positive = 1;

        if (x < 0) {
            positive = -1;
            x = Math.abs(x);
        }

        while (x != 0) {
            result = (result * 10) + (x % 10);
            x /= 10;
        }
        result *= positive;

        if (result != (int)result) {
            return 0;
        }
        return (int)result;
    }

}
