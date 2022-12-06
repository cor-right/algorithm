package offer.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BubbleSort {

    private static int[] bubbleSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.stream(bubbleSort(new int[]{0, 3, 2, 1, 9, -2, 100, 5, -110, 0, 3, 1000}))
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")));
    }



}
