package _2025.subjects._12_search_dp;

import java.util.*;

/**
 * 子集 Ⅱ
 *
 * @author 佳叙
 * @date 2025/4/8
 * @description <a href="https://leetcode.cn/problems/subsets-ii/description/"/>
 */
public class _90_subsets_2 {

    /**
     *
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        traversal(ans, new ArrayList<>(), 0, nums);
        return ans;
    }

    /**
     * 本质是一种搜索，我们选择 PRE-ORDER 的方式进行搜索
     *
     * @param ans
     * @param path
     * @param i
     * @param nums
     */
    private void traversal(List<List<Integer>> ans, List<Integer> path, int i, int[] nums) {
        ans.add(path);

        for (int j = i; j < nums.length; j++) {

            if (j > i && nums[i] == nums[j]) {
                continue;
            }

            path.add(nums[i]);
            traversal(ans, path, j + 1, nums);
            path.remove(path.size() - 1);
        }

    }

}