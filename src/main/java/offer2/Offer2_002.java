package offer2;

/**
 * @code https://leetcode.cn/problems/JFETK5/?favorite=e8X3pBZi
 *
 * 剑指 Offer II 002. 二进制加法
 * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "10"
 * 输出: "101"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 */
public class Offer2_002 {

    public static String addBinary(String a, String b) {
        String result = "";

        int ia = a.length() - 1;
        int ib = b.length() - 1;

        int carry = 0;
        while (ia >= 0 || ib >= 0) {
            int na = ia < 0 ? 0 : a.charAt(ia) - '0';
            int nb = ib < 0 ? 0 : b.charAt(ib) - '0';

            int ni = na ^ nb ^ carry;
            carry = (na & nb) | (na & carry) | (nb & carry);
            result = ni + result;

            ia--;
            ib--;
        }

        if (carry == 1) {
            result = '1' + result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1", "111"));
    }

}
