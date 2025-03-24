package _2025.daily;

/**
 * @author 佳叙
 * @date 2025/3/25
 * @description <a href="https://leetcode.cn/problems/count-prefixes-of-a-given-string/description/?envType=daily-question&envId=2025-03-24"/>
 */
public class _2255_count_prefixes_of_a_given_string {

    /**
     *
     * @param words
     * @param s
     * @return
     */
    public int countPrefixes(String[] words, String s) {
        int cnt = 0;
        for (String word: words) {
            if (word.length() <= s.length() && word.equals(s.substring(0, word.length()))) {
                cnt++;
            }
        }
        return cnt;
    }

}