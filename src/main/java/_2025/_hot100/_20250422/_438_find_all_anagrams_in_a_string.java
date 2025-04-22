package _2025._hot100._20250422;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到字符串中所有的异位词
 *
 * @author 佳叙
 * @date 2025/4/22
 * @description <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/?envType=study-plan-v2&envId=top-100-liked"/>
 */
public class _438_find_all_anagrams_in_a_string {

    /**
     * Slide window. Record char's num within a window
     *
     * 重点在于，一是使用窗口维护子串，二是通过窗口内的元素数量来判断是否是异位字符串
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) {
            return ans;
        }

        int[] numArr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            numArr[p.charAt(i) - 'a']++;
        }

        int num = 0;
        int[] memo = new int[26];

        int fast = 0;
        int slow = 0;
        while (fast < s.length()) {
            int index = s.charAt(fast) - 'a';
            fast++;

            memo[index]++;
            num++;

            while (memo[index] > numArr[index]) {
                memo[s.charAt(slow++) - 'a']--;
                num--;
            }

            if (num == p.length()) {
                ans.add(slow);
            }
        }

        return ans;
    }

}