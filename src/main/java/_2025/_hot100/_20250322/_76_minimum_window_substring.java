package _2025._hot100._20250322;

/**
 * @author jiaxu.zjx
 * @date 2025/3/22 19:53
 * @description <a href="https://leetcode.cn/problems/minimum-window-substring/description/"/>
 */
public class _76_minimum_window_substring {

    /**
     * Slide window.
     *
     * 这段代码的核心思想是利用滑动窗口技术，通过两个指针（left 和 right）动态调整窗口范围，寻找字符串 s 中包含字符串 t 所有字符的最小子串。
     * 其亮点在于高效地利用字符频率数组（sArr 和 tArr）来快速判断当前窗口是否满足条件，并通过扩展和收缩窗口的方式，动态更新最小子串。
     * 注意，先扩展、再收缩，在收缩到极限时进行判定。
     *
     * @param s s
     * @param t t
     * @return min window
     */
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int[] tArr = new int[128];
        int[] sArr = new int[128];
        for (int i = 0; i < t.length(); i++) {
            tArr[t.charAt(i)]++;
        }

        int sLen = 0;
        int tLen = t.length();

        String minStr = "";

        for (int left = 0, right = 0; right < s.length(); right++) {
            // Try expand
            sArr[s.charAt(right)]++;
            if (sArr[s.charAt(right)] <= tArr[s.charAt(right)]) {
                sLen++;
            }

            // Try minimum
            while (sLen == tLen) {
                sArr[s.charAt(left)]--;

                // Hit boundary
                if (sArr[s.charAt(left)] < tArr[s.charAt(left)]) {
                    if (minStr.isEmpty() || right - left + 1 < minStr.length()) {
                        minStr = s.substring(left, right + 1);
                    }
                    sLen--;
                }
                left++;
            }
        }

        return minStr;
    }


}
