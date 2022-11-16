package hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 滑动窗口
 */
public class Hot3 {

    /**
     *
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        Set<Character> set = new HashSet<>();

        int start = 0;
        int end = 1;

        int maxSize = 1;
        set.add(s.charAt(0));

        while (end < s.length()) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;

            } else {
                set.remove(s.charAt(start));
                start++;
            }

            maxSize = Math.max(maxSize, set.size());
        }

        return maxSize;
    }

    public int lengthOfLongestSubstring1(String s) {
        int left = 0;
        int maxLen = 0;

        if (s == null) {
            return 0;
        }
        if (s.length() <= 1) {
            return s.length();
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        for (int i = 1; i < s.toCharArray().length; i++) {
            Integer pos = map.get(s.charAt(i));
            if (pos != null) {
                left = Math.max(pos + 1, left);
            }
            maxLen = Math.max(maxLen, i - left + 1);
            map.put(s.charAt(i), i);
        }

        return maxLen;
    }



}
