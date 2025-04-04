package _2025.subjects._5_heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 重构字符串
 *
 * @author 佳叙
 * @date 2025/4/4
 * @description <a href="https://leetcode.cn/problems/reorganize-string/"/>
 */
public class _767_reorganize_string {



    /**
     * 最大堆 + 贪心：使用堆确保每次取得的字符和上一次取得的字符不一样，由于重复是由于频次高的字符造成的，因此要构建最大堆，优先把频次高的字符消耗掉. O(nlogn)
     * 桶排序 + 贪心：从偶数下标到奇数下标，按照频次从高到低分别填写对应字母. O(n)
     *
     * @param s
     * @return
     */
    public String reorganizeString(String s) {
        Map<Character, Integer> times = new HashMap<>();
        for (char ch : s.toCharArray()) {
            times.put(ch, times.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> times.get(b) - times.get(a));
        maxHeap.addAll(times.keySet());

        StringBuilder builder = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char curCh = maxHeap.poll();

            if (builder.length() > 0) {
                char lstCh = builder.charAt(builder.length() - 1);

                if (times.get(lstCh) > 0) {
                    maxHeap.offer(lstCh);
                }
            }

            times.put(curCh, times.get(curCh) - 1);
            builder.append(curCh);
        }

        return s.length() == builder.length() ? builder.toString() : "";
    }

}