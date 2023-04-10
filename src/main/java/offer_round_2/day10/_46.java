package offer_round_2.day10;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * 1 2 2
 * 12 2 dp[i - 1] + dp[i - 2]
 * 1 22
 *
 * dp[i - 1] + dp[i - 2]
 *
 * 提示：
 *
 * 0 <= num < 2^31
 * 通过次数242,424提交次数471,403
 * 请问您在哪类招聘中遇到此题？
 *
 */
public class _46 {

    public int translateNum(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }

        String number = String.valueOf(num);

        int[] dp = new int[number.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= number.length(); i++) {
            int sum = (number.charAt(i - 2) - '0') * 10 + (number.charAt(i - 1) - '0');
            dp[i] = (sum >= 10 && sum <= 25) ? dp[i - 1] + dp[i - 2] : dp[i - 1];
        }

        return dp[number.length()];
    }

    public static void main(String[] rags) {
        System.out.println(new _46().translateNum(12258));
    }

}
