package _2025._hot100._20250428;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 全排列
 *
 * @author 佳叙
 * @date 2025/4/28
 * @description <a href=""/>
 */
public class _46_permutations {

    /**
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        traversal(ans, new ArrayList<>(nums.length), nums, new boolean[nums.length]);
        return ans;
    }

    private void traversal(List<List<Integer>> ans, List<Integer> path, int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return ;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.add(nums[i]);

                traversal(ans, path, nums, visited);

                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }


}