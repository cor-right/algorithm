package offer_round_2.day16;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *
 *
 * 提示:
 *
 * 0 < nums.length <= 100
 * 说明:
 *
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 * 通过次数218,323提交次数395,822
 */
public class _45 {

    public String minNumber(int[] nums) {
        return join(quickSort(nums, 0, nums.length - 1));
    }


    private int[] quickSort(int[] nums, int left, int right) {
        if (right <= left) {
            return nums;
        }

        int curL = left;
        int curR = right;

        int middleNum = nums[curL];

        while (curL < curR) {
            while (curL < curR && comparator(middleNum, nums[curR]) <= 0) {
                curR--;
            }
            nums[curL] = nums[curR];
            while (curL < curR && comparator(nums[curL], middleNum) <= 0) {
                curL++;
            }
            nums[curR] = nums[curL];
        }
        nums[curL] = middleNum;

        quickSort(nums, left, curL - 1);
        quickSort(nums, curL + 1, right);
        return nums;
    }

    /**
     *
     * @param left
     * @param right
     * @return left < right: -1, left == right: 0, left > right: 1
     */
    private int comparator(int left, int right) {
        return (left + "" + right).compareTo(right + "" + left);
    }

    private String join(int[] nums) {
        StringBuilder builder = new StringBuilder();
        for (int num : nums) {
            builder.append(num);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new _45().minNumber(new int[] {0,9,8,7,6,5,4,3,2,1}));
    }

}
