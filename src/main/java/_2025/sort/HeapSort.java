package _2025.sort;

import java.util.Arrays;

/**
 * Heap sort. Always balance.
 *
 * @author 佳叙
 * @date 2025/3/30
 * @description <a href=""/>
 */
public class HeapSort {

    /**
     * Array is a kind of binary tree.
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[] {1, 5, 20, 1, 3, 5, 90, 1, 0};
        heapSort(arr);

        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void heapSort(int[] arr) {
        initHeap(arr);

        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[0] ^ arr[i];
            arr[0] = arr[0] ^ arr[i];
            arr[i] = arr[0] ^ arr[i];

            adjustHeap(arr, i, 0);
        }
    }

    /**
     * Build heap.
     *
     * @param arr
     */
    private static void initHeap(int[] arr) {
        // From leaf to root.
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, arr.length, i);
        }
    }

    private static void adjustHeap(int[] arr, int len, int root) {
        int largest = root;
        int left  = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != root) {
            arr[root]    = arr[root] ^ arr[largest];
            arr[largest] = arr[root] ^ arr[largest];
            arr[root]    = arr[root] ^ arr[largest];

            // Adjust subTree.
            adjustHeap(arr, len, largest);
        }
    }

}