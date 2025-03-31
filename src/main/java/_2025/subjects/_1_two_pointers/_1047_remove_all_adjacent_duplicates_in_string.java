package _2025.subjects._1_two_pointers;

import java.util.Arrays;

/**
 * 删除字符串中所有的相邻重复项
 *
 * <p>
 *     给出由小写字母组成的字符串 s，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *     在 s 上反复执行重复项删除操作，直到无法继续删除。
 *     在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * </p>
 * @author 佳叙
 * @date 2025/3/31
 * @description <a href="https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/description/"/>
 */
public class _1047_remove_all_adjacent_duplicates_in_string {

    /**
     * Two pointer. Same direction.
     * 双指针的 SLOW 本质就是在模拟栈的操作。
     *
     * @param s
     * @return
     */
    public String removeDuplicates(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int slow = 0;
        int fast = 0;

        char[] chars = s.toCharArray();

        while (fast < chars.length) {
            chars[slow] = chars[fast];

            if (slow > 0 && chars[slow] == chars[slow - 1]) {
                slow -= 2;
            }

            slow++;
            fast++;
        }

        return new String(chars, 0, slow);
    }

}