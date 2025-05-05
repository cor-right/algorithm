package _2025._hot100._20250504;

/**
 * 轮转数组
 *
 * @author 佳叙
 * @date 2025/5/4
 * @description <a href=""/>
 */
public class _189_rotate_array {

    /**
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        rotateWithReverse(nums, k);
    }

    private void rotateWithLoop(int[] nums, int k) {
        k = k % nums.length;



    }

    private void rotateWithReverse(int[] nums, int k) {
        for (int i = 0; i < nums.length / 2; i++) {
            swap(nums, i, nums.length - i - 1);
        }

        int mid = k % nums.length;
        for (int i = 0; i < mid / 2; i++) {
            swap(nums, i, mid - i);
        }

        for (int i = mid; i < nums.length - (nums.length - mid) / 2; i++) {
            swap(nums, i, nums.length - i - mid);
        }
    }

    private void swap(int[] nums, int cur, int tar) {
        int temp  = nums[cur];
        nums[cur] = nums[tar];
        nums[tar] = temp;
    }

}