package _2025.subjects._4_stack;

import java.util.Stack;

/**
 * 有效括号
 *
 * @author 佳叙
 * @date 2025/4/3
 * @description <a href="https://leetcode.cn/problems/valid-parentheses/description/"/>
 */
public class _20_valid_parentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }
            else {
                if (stack.isEmpty() || !legal(stack.pop(), s.charAt(i))) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean legal(char left, char right) {
        return (left == '(' && right == ')') || (left == '{' && right == '}') || left == '[' && right == ']';
    }

}