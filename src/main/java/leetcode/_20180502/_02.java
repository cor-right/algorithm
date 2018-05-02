package leetcode._20180502;

import java.util.Stack;

/**
 * Created by Jiaxu_Zou on 2018-5-2
 *
 * Title :
 *     evaluate-reverse-polish-notation
 *
 * Description :
 *     Evaluate the value of an arithmetic expression in Reverse Polish Notation.\
 *     Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 *
 * Examples :
 *     ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *     ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 * Key Word :
 *     Stack
 *
 * Note :
 *     无非是利用栈的原理模拟运算
 *
 * Link :
 *     https://www.nowcoder.com/practice/22f9d7dd89374b6c8289e44237c70447?tpId=46&tqId=29031&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 */
public class _02 {

    public int evalRPN(String[] tokens) {
        // check
        if (tokens == null || tokens.length <= 0)
            return 0;
        // main
        Stack<Integer> digits = new Stack<Integer>();
        int pointer = 0;
        while (pointer < tokens.length) {
            try {
                int digit = Integer.parseInt(tokens[pointer]);
                // is digit, push in
                digits.push(digit);
            } catch(Exception ex) {
                // is operator, calculate and push
                int digitB = digits.pop();  // last digit
                int digitA = digits.pop();  // first digit
                if (tokens[pointer].trim().equals("+")) {
                    digits.push(digitA + digitB);
                } else if (tokens[pointer].trim().equals("-")) {
                    digits.push(digitA - digitB);
                } else if (tokens[pointer].trim().equals("*")) {
                    digits.push(digitA * digitB);
                } else if (tokens[pointer].trim().equals("/")) {
                    digits.push(digitA / digitB);
                }
            }
            pointer++;
        }
        return digits.pop();
    }

}
