package _2025.subjects._2_binary_search;

/**
 * 分割数组的最大值
 *
 * <p>
 *     给定一个非负整数数组 nums 和一个整数 k ，你需要将这个数组分成 k 个非空的连续子数组，使得这 k 个子数组各自和的最大值 最小。
 *     返回分割后最小的和的最大值。
 *     子数组是数组中连续的部份。
 * </p>
 *
 *
 * @author 佳叙
 * @date 2025/4/1
 * @description <a href="https://leetcode.cn/problems/split-array-largest-sum/description/"/>
 */
public class _410_split_array_largest_sum {

    /**
     * 「使……最大值尽可能小」是二分搜索题目常见的问法。
     *
     * 贪心 + 二分
     * - 贪心：当我们选定一个值 x，我们可以线性地验证是否存在一种分割方案，满足其最大分割子数组和不超过 x
     * - 二分：根据最终产生的子数组的数量，可以判断是否向左还是向右
     *
     * 尽可能小，就是尽量向左，因此使用模糊的方式，向左查找
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public int splitArray(int[] nums, int k) {
        int right = 0;
        int left = 0;

        for (int num : nums) {
            right += num;
            left = Math.max(num, left);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (satisfy(nums, mid, k)) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean satisfy(int[] nums, int max, int k) {
        int cnt = 1; // Here I was wrong.
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum > max) {
                sum = nums[i];
                cnt++;
            }
        }

        return cnt <= k;
    }

}