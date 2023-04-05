package offer_round_2.day5;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例 1:
 *
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * 示例 2:
 *
 * 输入：s = ""
 * 输出：' '
 *
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 50000
 *
 * 通过次数310,344提交次数500,822
 */
public class _50 {

    /**
     * 辅助空间，进行标记
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> et : map.entrySet()) {
            if (et.getValue() == 1) {
                return et.getKey();
            }
        }
        return ' ';
    }

//    public static void main(String[] rags) {
//        System.out.println(new _50().firstUniqChar("cc"));
//        System.out.println(new _50().firstUniqChar("aadadaadc"));
//    }

}
