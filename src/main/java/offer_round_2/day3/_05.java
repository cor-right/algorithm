package offer_round_2.day3;

/**
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 10000
 *
 * 通过次数631,679提交次数837,584
 */
public class _05 {

    public String replaceSpace(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }

        StringBuilder sb = new StringBuilder("");

        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                sb.append("%20");
            }
            else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

}
