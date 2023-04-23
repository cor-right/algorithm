package offer_round_2.day17;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 * 通过次数430,018提交次数746,274
 */
public class _40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[]{};
        }
        if (arr == null || arr.length == 0) {
            return new int[] {};
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i : arr) {
            heap.offer(i);
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }

        return result;
    }

    public static void main(String[]args) {
        Arrays.stream(new _40().getLeastNumbers(new int[]{3, 2, 1}, 2)).forEachOrdered(System.out::println);
    }

}
