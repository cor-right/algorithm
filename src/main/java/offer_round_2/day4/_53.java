package offer_round_2.day4;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 *
 *
 * 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * 通过次数372,407提交次数705,328
 */
public class _53 {

    /**
     *
     * binary search
     *
     * time complexity: log(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        return binarySearch(nums, target + 1, 0, nums.length - 1) - binarySearch(nums, target, 0, nums.length - 1);
    }

    /**
     * return the index of target number, or return the index of left bound
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return
     */
    private int binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return left;
        }

        int mid = (left + right) / 2;
        if (nums[mid] >= target) {
            return binarySearch(nums, target, left, mid - 1);
        }
        else {
            return binarySearch(nums, target, mid + 1, right);
        }
    }

//    public static void main(String[] str) {
//        System.out.println(new _53().search(new int[] {1, 1, 1, 1}, 2));
//    }


}
