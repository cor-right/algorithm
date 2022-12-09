package offer.day19;

/**
 * 剑指 Offer 64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 *
 *
 * 限制：
 *
 * 1 <= n <= 10000
 */
public class Offer64 {

    public int sumNums(int n) {
        return sum(n);
    }

    private int sum(int cur) {
        boolean bool = cur > 0 && (cur = cur + sum(cur - 1)) > 0;
        return cur;
    }

}
