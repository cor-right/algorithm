package offer.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HeapSort {

    private static int[] headSort(int[] nums) {
        // 将数组构建成大根堆
        createHeap(nums);

        // 每次将根节点（最大的数）与末尾数交换，这样最后一个数就是最大的，然后从头调整剩余部分的堆，得到下一个最大的数，循环往复得到排序好的数
        // 大根堆用于从小到大，小根堆用于从大到小
        int len = nums.length - 1;
        while (len > 0) {
            int temp = nums[0];
            nums[0] = nums[len];
            nums[len] = temp;

            adjustHeap(nums, 0, len - 1);
            len--;
        }
        return nums;
    }

    /**
     *
     * @param nums
     */
    private static void createHeap(int[] nums) {
        int maxIndex = nums.length - 1;
        for (int i = (maxIndex - 1) / 2; i >= 0; i--) {
            adjustHeap(nums, i, maxIndex);
        }
    }

    private static void adjustHeap(int[] nums, int parent, int maxIndex) {
        int childIndex = parent * 2 + 1;

        while (childIndex <= maxIndex) {

            if (childIndex + 1 <= maxIndex && nums[childIndex + 1] > nums[childIndex]) {
                childIndex++;
            }

            if (nums[parent] == nums[childIndex]) {
                return ;
            }

            if (nums[childIndex] > nums[parent]) {
                int temp = nums[childIndex];
                nums[childIndex] = nums[parent];
                nums[parent] = temp;
            }

            parent = childIndex;
            childIndex = parent * 2 + 1;

        }
    }


    public static void main(String[] args) {
        System.out.println(
                Arrays.stream(headSort(new int[]{0, 3, 2, 1, 9, -2, 100, 5, -110, 0, 3, 1000}))
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")));
    }


}
