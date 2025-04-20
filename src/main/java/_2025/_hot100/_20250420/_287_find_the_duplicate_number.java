package _2025._hot100._20250420;

/**
 * 寻找重复数
 *
 * @author 佳叙
 * @date 2025/4/20
 * @description <a href="https://leetcode.cn/problems/find-the-duplicate-number/description/"/>
 */
public class _287_find_the_duplicate_number {

    /**
     * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
     * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
     * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
     *
     * 位运算：和异或没关系，而是计算每一位出现的次数，相对于正常无重复数组出现的次数，是否更大，更大则整明该位是重复数字为1的位置，则加上它。
     * 链表：双指针，判断是否成环。下标代表位置，数值代表next，快慢指针判断是否成环。
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        return 0;
    }

}