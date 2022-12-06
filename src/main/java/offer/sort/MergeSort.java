package offer.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSort {

    private static int[] mergeSort(int[] arr) {
        mergeSortCore(arr, 0, arr.length - 1);
        return arr;
    }

    private static void mergeSortCore(int[] arr, int left, int right) {
        if (left >= right) {
            return ;
        }

        int middle = left + (right - left) / 2;

        mergeSortCore(arr, left, middle);
        mergeSortCore(arr, middle + 1, right);
        merge(arr, left, right, middle);
    }

    private static void merge(int[] arr, int left, int right, int middle) {
        int startLeft = left;
        int startRight = middle + 1;

        int[] temp = new int[right - left + 1];
        int index = 0;

        while (startLeft <= middle && startRight <= right) {
            temp[index++] = arr[startLeft] < arr[startRight] ? arr[startLeft++] : arr[startRight++];
        }
        while (startLeft <= middle) {
            temp[index++] = arr[startLeft++];
        }
        while (startRight <= right) {
            temp[index++] = arr[startRight++];
        }

        for (int i = left; i <= right; i++) {
            arr[i] = temp[i - left];
        }
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.stream(mergeSort(new int[]{0, 3, 2, 1, 9, -2, 100, 5, -110, 0, 3, 1000}))
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")));
    }

}
