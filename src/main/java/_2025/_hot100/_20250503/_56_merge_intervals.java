package _2025._hot100._20250503;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 佳叙
 * @date 2025/5/3
 * @description <a href=""/>
 */
public class _56_merge_intervals {

    /**
     * 合并区间
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        List<int[]> inp = Arrays.stream(intervals).sorted(Comparator.comparingInt(a -> a[0])).collect(Collectors.toList());
        List<int[]> ans = new ArrayList<>();

        int left  = inp.get(0)[0];
        int right = inp.get(0)[1];

        for (int i = 1; i < inp.size(); i++) {
            int[] cur = inp.get(i);

            if (cur[0] > right) {
                ans.add(new int[] {left, right});
                left  = cur[0];
                right = cur[1];
            }
            else {
                left  = Math.min(left,  cur[0]);
                right = Math.max(right, cur[1]);
            }
        }

        ans.add(new int[] {left, right});

        int[][] ansArr = new int[ans.size()][2];
        return ans.toArray(ansArr);
    }

}