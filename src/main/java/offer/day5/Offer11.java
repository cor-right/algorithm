package offer.day5;

/**
 * @code https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=108mt86
 *
 *
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
 *
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：numbers = [3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：numbers = [2,2,2,0,1]
 * 输出：0
 *
 *
 * 提示：
 *
 * n == numbers.length
 * 1 <= n <= 5000
 * -5000 <= numbers[i] <= 5000
 * numbers 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 *
 *
 * 二分查找
 */
public class Offer11 {

    /**
     *
     * 二分查找，递归，找到 左边大于右边的那个，等于的话继续往左找，因为是要找最小的数
     *
     * @param numbers
     * @return
     */
    public static int minArray(int[] numbers) {
        return numbers[search(numbers, 0, numbers.length - 1)];
    }

    private static int search(int[] nums, int left, int right) {
        if (left > right) {
            return 0;
        }

        int mid = left + (right - left ) / 2;

        if ((mid > 0 && nums[mid - 1] > nums[mid])) {
            return mid;
        }
        if ((mid < right && nums[mid] > nums[mid + 1])) {
            return mid + 1;
        }

        int ls = search(nums, left, mid - 1);
        int rs = search(nums, mid + 1, right);

        return ls > 0 ? ls : rs;
    }

    public static void main(String[] args) {
        System.out.println(minArray(new int[]{3, 3, 3, 3, 1}));
    }

}
