package offer.day16;

import java.util.Arrays;

/**
 * @code https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=108mt86
 *
 * 面试题45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
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
 */
public class Offer45 {

    /**
     *
     * 0 1x 1xx 2x 2xx 3x 3xx
     *
     * 1000 < 100 <  10 < 1
     * 10001 < 2
     *
     * 10002 < 21000
     *
     * 不需要有一个固定规律，只要确定一下比较规则即可
     * left + right < right + left，则 left + right
     *
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return Arrays.stream(nums).mapToObj(String::valueOf).reduce((a, b) -> a + b).orElse("");
    }

    private void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return ;
        }

        int temp = nums[start];

        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && bigger(nums[j], temp) >= 0) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && bigger(nums[i], temp) <= 0) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = temp;

        sort(nums, start, i - 1);
        sort(nums, i + 1, end);
    }

    /**
     * 大小的确定，取决于拼接后，从高到低每一位的数值的大小，也就是字典序
     * @param num
     * @param tar
     * @return 1 0 -1: num+tar > tar+num  | num+tar == tar+num | num+tar < tar+num
     */
    private int bigger(int num, int tar) {

        String numFir = String.valueOf(num) + tar;
        String tarFir = String.valueOf(tar) + num;

//        return numFir.compareTo(tarFir);

        for (int i = 0; i < numFir.length(); i++) {
            if (numFir.charAt(i) > tarFir.charAt(i)) {
                return 1;
            }
            if (numFir.charAt(i) < tarFir.charAt(i)) {
                return -1;
            }
        }
        return 0;
    }

}
