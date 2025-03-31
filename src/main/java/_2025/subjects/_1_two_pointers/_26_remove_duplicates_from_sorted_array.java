package _2025.subjects._1_two_pointers;

/**
 * 
 *
 * @author 佳叙
 * @date 2025/3/31
 * @description <a href=""/>
 */
public class _26_remove_duplicates_from_sorted_array {

    /**
     * Two pointer.
     * Same direction.
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int fast = 0;
        int slow = 0;

        while (fast < nums.length) {
            if (fast == 0 || nums[fast - 1] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }

}