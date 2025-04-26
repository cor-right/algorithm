package _2025._hot100._20250424;

import java.util.Arrays;
import java.util.List;

/**
 * 分割回文串
 *
 * @author 佳叙
 * @date 2025/4/25
 * @description <a href=""/>
 */
public class _131_palindrome_partitioning {

    /**
     * 给你一个字符串 s，请你将 s 分割成一些 子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        boolean[][] memo = new boolean[s.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            memo[i][i] = true;
        }

        return null;
    }


}