package leetcode75.day2;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 *
 *
 * 示例 1:
 *
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 *
 * 输入：s = "paper", t = "title"
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s 和 t 由任意有效的 ASCII 字符组成
 * 通过次数196,025提交次数395,158
 */
public class _205 {

    public boolean isIsomorphic(String s, String t) {
        if (s == null) {
            return true;
        }

        Integer[] smark = new Integer[128];
        Integer[] tmark = new Integer[128];

        for (int i = 0; i < s.length(); i++) {
            char s_ch = s.charAt(i);
            char t_ch = t.charAt(i);

            if (smark[s_ch] == null && tmark[t_ch] == null) {
                smark[s_ch] = i;
                tmark[t_ch] = i;
                continue;
            }

            if (smark[s_ch] == null || tmark[t_ch] == null) {
                return false;
            }
            if (!smark[s_ch].equals(tmark[t_ch])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] rags) {
        System.out.println(new _205().isIsomorphic("egg", "add"));
    }

}
