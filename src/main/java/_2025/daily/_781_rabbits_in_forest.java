package _2025.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * 森林中的兔子
 *
 * @author 佳叙
 * @date 2025/4/20
 * @description <a href="https://leetcode.cn/problems/rabbits-in-forest/description/?envType=daily-question&envId=2025-04-20"/>
 */
public class _781_rabbits_in_forest {


    /**
     * 森林中有未知数量的兔子。提问其中若干只兔子 "还有多少只兔子与你（指被提问的兔子）颜色相同?" ，将答案收集到一个整数数组 answers 中，其中 answers[i] 是第 i 只兔子的回答。
     * 给你数组 answers ，返回森林中兔子的最少数量。
     *
     * @param answers
     * @return
     */
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();

        int total = 0;
        for (int ans : answers) {
            int cnt = map.getOrDefault(ans + 1, 0) + 1;

            if (ans + 1 == cnt) {
                total += cnt;
                map.remove(ans + 1);
            } else {
                map.put(ans + 1, cnt);
            }
        }

        for (Integer value : map.keySet()) {
            total += value;
        }

        return total;
    }

}