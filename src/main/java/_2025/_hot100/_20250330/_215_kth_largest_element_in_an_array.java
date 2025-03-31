package _2025._hot100._20250330;

/**
 * @author 佳叙
 * @date 2025/3/30
 * @description <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/description/"/>
 */
public class _215_kth_largest_element_in_an_array {

    public int findKthLargest(int[] nums, int k) {
        return nums[partition(nums, 0, nums.length - 1, k)];
    }

    private int partition(int[] nums, int low, int high, int k) {
        if (low < high) {
            int mid = quickSort(nums, low, high);

            if (mid == k - 1) {
                return mid;
            }

            if (mid < k - 1) {
                return partition(nums, mid + 1, high, k);
            }
            else {
                return partition(nums, low, mid - 1, k);
            }
        }

        return -1;
    }

    private int quickSort(int[] nums, int low, int high) {
        int pivot = nums[low];

        int left  = low + 1;
        int right = high;

        while (left < right) {
            while (left < right && nums[left] >= pivot) {
                left++;
            }
            while (left < right && nums[right] <= pivot) {
                right--;
            }

            nums[left]  = nums[left] ^ nums[right];
            nums[right] = nums[left] ^ nums[right];
            nums[left]  = nums[left] ^ nums[right];
        }

        if (nums[left] < pivot) {
            left--;
        }

        nums[left] = nums[left] ^ nums[low];
        nums[low]  = nums[left] ^ nums[low];
        nums[left] = nums[left] ^ nums[low];

        return left;
    }

    public static void main(String[] args) {
        System.out.println(new _215_kth_largest_element_in_an_array().findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
    }

}