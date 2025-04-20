package _2025._hot100._20250420;

import java.util.List;
import java.util.Set;

/**
 * 删除无效的括号
 *
 * @author 佳叙
 * @date 2025/4/20
 * @description <a href="https://leetcode.cn/problems/remove-invalid-parentheses/description/"/>
 */
public class _301_remove_invalid_parentheses {

    /**
     *
     * @param s
     * @return
     */
    public List<String> removeInvalidParentheses(String s) {
        return null;
    }

    private void traversal(Set<String> ans, String partAns, int left, int right, int cur, char[] str) {
        if (right > left) {
            return ;
        }

        if (cur >= str.length && left == right) {
            ans.add(partAns);
            return ;if
        }

        if (str[cur] == '(') {

        }
    }

}