package offer.day10;

/**
 * @code https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=108mt86
 *
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
 * 1 8 8 2 2 2
 *
 * 1 8 8 2 2 2
 * 18 8 2 2 2
 * 18 8 22 2
 * 1 8 8 22 2
 * 1 8 8 2 22
 * 18 8 2 22
 *
 * 提示：
 *
 * 0 <= num < 231
 */
public class Offer46 {

    /**
     * [0, 25] -> [a, z]
     *
     *
     * dp[i - 1]  + dp[i - 2]
     * dp[i - 1]
     *
     * 如果相邻两个数字的拼接满足 10 ~ 25 的条件，那么就意味着，以这个拼接为基础，增加了 dp[i -2] 个可用的解。
     *
     * @param num
     * @return
     */
    public int translateNum(int num) {

        String s = String.valueOf(num);
        if (s.length() == 1) {
            return 1;
        }

        // [null, s[0], s[1]]
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            dp[i] = dp[i - 1] + (((s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0') > 25 || (s.charAt(i - 2) == '0') ? 0 : dp[i - 2]);

        }

        return dp[s.length()];

    }

}
