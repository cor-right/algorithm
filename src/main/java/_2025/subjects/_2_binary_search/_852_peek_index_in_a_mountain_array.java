package _2025.subjects._2_binary_search;

/**
 * 山脉数组的峰值索引
 *
 * <p>
 *     给定一个长度为 n 的整数 山脉 数组 arr ，其中的值递增到一个 峰值元素 然后递减。
 *     返回峰值元素的下标。
 *     你必须设计并实现时间复杂度为 O(log(n)) 的解决方案。
 * </p>
 *
 * @author 佳叙
 * @date 2025/4/1
 * @description <a href="https://leetcode.cn/problems/peak-index-in-a-mountain-array/description/"/>
 */
public class _852_peek_index_in_a_mountain_array {

    /**
     * 二分查找，找递增序列的右边界
     *
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray(int[] arr) {
        int left  = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            if (increasing(arr, mid)) {
                left = mid;
            }
            else {
                right = mid - 1;
            }
        }

        return left;
    }

    private boolean increasing(int[] arr, int index) {
        if (index <= 0) {
            return true;
        }

        return arr[index] > arr[index - 1];
    }

}