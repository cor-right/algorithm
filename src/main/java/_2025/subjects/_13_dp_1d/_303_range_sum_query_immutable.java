package _2025.subjects._13_dp_1d;

/**
 * 区域和检索 - 数组不可变
 *
 * @author 佳叙
 * @date 2025/4/11
 * @description <a href="https://leetcode.cn/problems/range-sum-query-immutable/description/"/>
 */
public class _303_range_sum_query_immutable {

        private int[] sums;

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(left,right);
     *
     * 显然就是前缀和.
     */
    public _303_range_sum_query_immutable(int[] nums) {
        sums = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }

}