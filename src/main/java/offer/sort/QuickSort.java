package offer.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSort {


    private static int[] quickSort(int[] nums) {
        quickSortCore(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSortCore(int[] nums, int left, int right) {
        if (left >= right) {
            return ;
        }

        int curLeft = left;
        int curRight = right;

        int temp = nums[curLeft];

        while (curLeft < curRight) {
            while (curLeft < curRight && nums[curRight] >= nums[curLeft]) {
                curRight--;
            }
            nums[curLeft] = nums[curRight];
            while (curLeft < curRight && nums[curLeft] <= nums[curRight]) {
                curLeft++;
            }
            nums[curRight] = nums[curLeft];
        }
        nums[curLeft] = temp;

        quickSortCore(nums, left, curLeft - 1);
        quickSortCore(nums, curLeft + 1, right);
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.stream(quickSort(new int[]{0, 3, 2, 1, 9, -2, 100, 5, -110, 0, 3, 1000}))
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")));
    }

}
