package _2025.subjects._1_two_pointers;

/**
 * 删除有序数组中的重复项Ⅱ
 *
 * <p>
 *     给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 *     不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * </p>
 * @author 佳叙
 * @date 2025/3/31
 * @description <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/"/>
 */
public class _80_remove_duplicates_from_sorted_array_2 {

    /**
     * Two pointers. Same direction.
     *
     * <p>
     *     注意这里 slow 是用来维护已处理的数据的，所以判断是否超过两个，应该用 slow 来判断，而不是 fast.
     * </p>
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int fast = 2;
        int slow = 2;
        while (fast < nums.length) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }

}