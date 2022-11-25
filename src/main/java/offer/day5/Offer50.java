package offer.day5;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @code https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=108mt86
 *
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
 *
 *
 */
public class Offer50 {

    /**
     * 哈希表，有序哈希表
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        LinkedHashMap<Character, Boolean> map = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            if (!map.keySet().contains(c)) {
                map.put(c, true);
            } else {
                map.put(c, false);
            }
        }

        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                return entry.getKey();
            }
        }
        return ' ';
    }

}
