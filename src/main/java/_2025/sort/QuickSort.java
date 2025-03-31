package _2025.sort;

import java.util.Arrays;

/**
 * @author 佳叙
 * @date 2025/3/30
 * @description <a href=""/>
 */
public class QuickSort {

    private static void partition(int[] arr, int low, int high) {
        if (low < high) {
            int middle = quickSort(arr, low, high);

            partition(arr, low, middle - 1);
            partition(arr, middle + 1, high);
        }

    }

    private static int quickSort(int[] arr, int low, int high) {
        int pivot = arr[low];

        int left  = low + 1;
        int right = high;

        while (left < right) {
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            while (left < right && arr[right] >= pivot) {
                right--;
            }

            swap(arr, left, right);
        }

        if (arr[left] > pivot) {
            left--;
        }
        swap(arr, low, left);

        return left;
    }

    private static void swap(int[] numbers, int a, int b) {
        int temper = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temper;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 5, 20, 1, 3, 5, 90, 1, 0};
        partition(arr, 0, arr.length - 1);

        Arrays.stream(arr).forEach(System.out::println);
    }

}