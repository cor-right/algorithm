package _2025.subjects._14_dp_2d;

import java.util.List;

/**
 * 三角形最小路径和
 *
 * @author 佳叙
 * @date 2025/4/11
 * @description <a href="https://leetcode.cn/problems/triangle/"/>
 */
public class _120_triangle {

    /**
     * 这里是从上往下
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> pre = triangle.get(i - 1);
            List<Integer> cur = triangle.get(i);

            for (int j = 1; j < i; j++) {
                cur.set(j, Math.min(pre.get(j), pre.get(j - 1)) + cur.get(j));
            }

            cur.set(0, pre.get(0) + cur.get(0));
            cur.set(i, pre.get(i - 1) + cur.get(i));
        }

        return triangle.get(triangle.size() - 1).stream().min(Integer::compareTo).orElse(0);
    }

    /**
     * 这里是从下往上，因为每次都是收敛，所以代码更好看
     *
     * @param triangle
     * @return
     */
    private int minimumTotalBottomUp(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> cur = triangle.get(i);
            List<Integer> pre = triangle.get(i + 1);

            for (int j = 0; j < cur.size(); j++) {
                cur.set(j, cur.get(j) + Math.min(pre.get(j), pre.get(j + 1)));
            }
        }

        return triangle.get(0).get(0);
    }

}