package offer_round_2.day4;

/**
 * 81. Search in Rotated Sorted Array II
 * There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
 *
 * Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
 *
 * Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
 *
 * You must decrease the overall operation steps as much as possible.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * nums is guaranteed to be rotated at some pivot.
 * -104 <= target <= 104
 */
public class _leetcode_4_81 {


    /**
     * increasing array, rotated
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target || nums[left] == target || nums[right] == target) {
                return true;
            }

            if (nums[left] == nums[mid]) {
                // if the left is the same as middle, then from mid to right is all equally,
                // with such situation, we can contract the right bound and not omit and digit
                right--;
            }
            else if (nums[left] < nums[mid]) {
                // the left part is in increasing order
                if (nums[mid] > target && nums[left] < target) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else {
                // the right part is in increasing order
                if (nums[mid] < target && nums[right] > target) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }

//    public static void main(String[] str) {
//        System.out.println(new _leetcode_4_81().search(new int[] {3, 1, 3, 3, 3}, 1));
//        System.out.println(new _leetcode_4_81().search(new int[] {3, 3, 3, 1, 3}, 4));
//        System.out.println(new _leetcode_4_81().search(new int[] {1, 2, 3}, 2));
//        System.out.println(new _leetcode_4_81().search(new int[] {2, 3, 3, 1}, 2));
//        System.out.println(new _leetcode_4_81().search(new int[] {2,5,6,0,0,1,2}, 3));
//        System.out.println(new _leetcode_4_81().search(new int[] {2,5,6,0,0,1,2}, 0));
//    }

}
