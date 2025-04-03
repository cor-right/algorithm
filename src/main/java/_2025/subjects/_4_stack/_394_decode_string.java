package _2025.subjects._4_stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 解码字符串
 *
 * @author 佳叙
 * @date 2025/4/3
 * @description <a href="https://leetcode.cn/problems/decode-string/description/"/>
 */
public class _394_decode_string {

    /**
     * 辅助栈
     *
     * <p>
     *     用栈来保存前缀，包括次数和前缀字符串，每次 [ 就是一次入栈
     * </p>
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Stack<Integer> times = new Stack<>();
        Stack<String>  chars = new Stack<>();

        StringBuilder str = new StringBuilder();
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                cnt = cnt * 10 + (s.charAt(i) - '0');
            }

            if (s.charAt(i) == '[') {
                times.push(cnt);
                chars.push(str.toString());

                str = new StringBuilder();
                cnt = 0;
            }

            if (Character.isLetter(s.charAt(i))) {
                str.append(s.charAt(i));
            }

            if (s.charAt(i) == ']') {
                StringBuilder partStr = new StringBuilder();

                int loopTimes = times.pop();
                for (int j = 0; j < loopTimes; j++) {
                    partStr.append(str);
                }

                str = new StringBuilder(chars.pop() + partStr);
            }
        }

        return str.toString();
    }

}