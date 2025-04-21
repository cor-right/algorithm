package _2025._hot100._20250421;

import java.util.*;

/**
 * 杨辉三角
 *
 * @author 佳叙
 * @date 2025/4/21
 * @description <a href="https://leetcode.cn/problems/pascals-triangle/description/?envType=study-plan-v2&envId=top-100-liked"/>
 */
public class _118_pascals_triangle {

    /**
     * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 1) {
            return Arrays.asList(Arrays.asList(1));
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            row.add(1);

            for (int j = 1; j < i; j++) {
                row.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
            }

            row.add(1);
            ans.add(row);
        }

        return ans;
    }

}