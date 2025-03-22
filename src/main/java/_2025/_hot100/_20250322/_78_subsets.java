package _2025._hot100._20250322;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author jiaxu.zjx
 * @date 2025/3/22 20:43
 * @description <a href="https://leetcode.cn/problems/subsets/description/"/>
 */
public class _78_subsets {

    /**
     * Recursion. Also is a kind of dynamic planning.
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> partResult = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            recursion(results, partResult, nums, i);
        }

        results.add(new ArrayList<>());
        return results;
    }

    /**
     * Only goes right side.
     *
     * @param results
     * @param nums
     */
    private void recursion(List<List<Integer>> results, List<Integer> part, int[] nums, int position) {
        part.add(nums[position]);
        results.add(new ArrayList<>(part));

        for (int i = position + 1; i < nums.length; i++) {
            recursion(results, part, nums, i);
        }

        part.remove(part.size() - 1);
    }

    /**
     * dynamic planning.
     *
     * dp[i] = dp[i - 1] + nums[i]
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> partResults = new ArrayList<>();

            for (int j = 0; j < results.size(); j++) {
                partResults.add(Stream.of(results.get(j), Arrays.asList(nums[i])).flatMap(List::stream).collect(Collectors.toList()));
            }
            results.addAll(partResults);
        }

        return results;
    }

    public static void main(String[] args) {
        System.out.println(subsets2(new int[] {1, 2, 3}));
    }

}
