package offer.day4;

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
 */
public class Offer53 {

    /**
     *
     * 二分查找最快
     *
     * 直接循环最简单
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        return useBinarySearch(nums, target);
    }

    private static int useForLoop(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            }
            if (num > target) {
                break;
            }
        }
        return count;
    }

    /**
     * 可以再次简化，只查找右边界
     *
     * @param nums
     * @param target
     * @return
     */
    private static int useBinarySearch(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        // left bound
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (target <= nums[mid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        int left = j;

        // right bound
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (target >= nums[mid]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        int right = i;

        return right - left - 1;
    }



    public static void main(String[] args) {
        System.out.println(search(new int[] {5,7,7,8,8,10}, 11));
    }

}
