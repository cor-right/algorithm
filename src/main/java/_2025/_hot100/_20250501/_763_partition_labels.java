package _2025._hot100._20250501;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 划分字母区间
 *
 * @author 佳叙
 * @date 2025/5/1
 * @description <a href=""/>
 */
public class _763_partition_labels {

    /**
     * 最后一次出现的位置
     *
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        int[] appearance = new int[26];
        for (int i = 0; i < s.length(); i++) {
            appearance[s.charAt(i) - 'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();

        int pre  = -1;
        int tail = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == appearance[s.charAt(i) - 'a'] && i >= tail) {
                ans.add(i - pre);
                pre = i;
            }
            tail = Math.max(tail, appearance[s.charAt(i) - 'a']);
        }

        return ans;
    }


}