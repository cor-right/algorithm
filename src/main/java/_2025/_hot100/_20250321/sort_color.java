package _2025._hot100._20250321;

import java.util.function.BiConsumer;

/**
 * @author 佳叙
 * @date 2025/3/21
 * @description <a href="https://leetcode.cn/problems/sort-colors/description/"/>
 */
public class sort_color {

    /**
     * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
     *
     * 单次遍历：三指针，遇到0放到最左边，遇到2放到最右边，遇到1跳过
     * 双次遍历：记录好0、1、2的数量，并按照数量重新赋值数组
     *
     * 输入：[2,0,2,1,1,0]
     * 输出：[0,0,1,1,2,2]
     *
     * @param nums nums
     */
    public void sortColors(int[] nums) {
        if (nums.length == 1) {
            return ;
        }

        // The pointers left and right serve to maintain a "sorted area", while the current pointer is responsible for traversing the array and processing each element.
        int left = 0;
        int right = nums.length - 1;
        int current = 0;

        BiConsumer<Integer, Integer> swap = (a, b) -> {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        };

        while (current <= right) {
            int num = nums[current];

            if (num == 1) {
                current++;
            }
            else if (num == 0) {
                swap.accept(left, current);
                left++;
                current++;
            }
            else {
                swap.accept(current, right);
                right--;
            }
        }
    }

}