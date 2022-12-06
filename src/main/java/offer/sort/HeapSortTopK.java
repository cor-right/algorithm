package offer.sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class HeapSortTopK {

    public static void main(String[] args) {
        System.out.println(
                Arrays.stream(topK(new int[]{0, 3, 2, 1, 9, -2, 100, 5, -110, 0, 3, 1000}, 3))
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")));
    }

    private static int[] topK(int[] nums, int k) {
        // 默认小根堆，从大到小
//        PriorityQueue<Integer> heap = new PriorityQueue<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);

        Arrays.stream(nums).forEach(heap::offer);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }

        return result;
    }

}
