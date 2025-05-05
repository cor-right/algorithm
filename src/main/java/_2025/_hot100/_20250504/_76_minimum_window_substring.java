package _2025._hot100._20250504;

/**
 * 最小覆盖子串
 *
 * @author 佳叙
 * @date 2025/5/4
 * @description <a href=""/>
 */
public class _76_minimum_window_substring {

    /**
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int[] tar = new int[128];
        for (char ch : t.toCharArray()) {
            tar[ch]++;
        }

        String ans = "";
        int cur = 0;

        int[] nums = new int[128];
        for (int i = 0, j = 0; j < s.length(); j++) {
            nums[s.charAt(j)]++;
            if (nums[s.charAt(j)] <= tar[s.charAt(j)]) {
                cur++;
            }

            while (cur == t.length()) {
                nums[s.charAt(i)]--;

                // Hit boundary
                if (nums[s.charAt(i)] < tar[s.charAt(i)]) {
                    ans = (ans.equals("")  || ans.length() > j - i) ? s.substring(i, j + 1) : ans;
                    cur--;
                }
                i++;
            }
        }

        return ans;
    }

}