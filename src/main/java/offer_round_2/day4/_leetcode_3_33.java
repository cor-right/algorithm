package offer_round_2.day4;

/**
 * 33. Search in Rotated Sorted Array
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 *
 * Input: nums = [1], target = 0
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * -104 <= target <= 104
 *
 * 通过次数713,872提交次数1,629,798
 */
public class _leetcode_3_33 {

    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;
            System.out.println(left + " " + right + " " + mid);

            if (nums[mid] == target) {
                return mid;
            }

            if (target < nums[mid]) {
                if (nums[left] < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else {
                if (nums[right] > nums[mid] &&  target <= nums[right]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new _leetcode_3_33().search(new int [] {3, 1}, 1));
        System.out.println(new _leetcode_3_33().search(new int [] {4,5,6,7,0,1,2}, 4));
        System.out.println(new _leetcode_3_33().search(new int [] {4,5,6,7,0,1,2}, 3));
        System.out.println(new _leetcode_3_33().search(new int [] {4,5,6,7,0,1,2}, 0));
//        System.out.println(new _leetcode_3_33().search(new int [] {1}, 0));
//        System.out.println(new _leetcode_3_33().search(new int [] {1}, 1));
        System.out.println(new _leetcode_3_33().search(new int [] {4,5,6,7,8,1,2,3}, 8));
    }

}
