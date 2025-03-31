package _2025._hot100._20250331;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

/**
 * 除自身以外数组的乘积
 *
 * @author 佳叙
 * @date 2025/3/31
 * @description <a href="https://leetcode.cn/problems/product-of-array-except-self/description/"/>
 */
public class _238_product_of_array_except_self {

    /**
     * 前缀和.
     *
     * <p>
     *     定义：对于一个给定的数列\(a[1],a[2],\cdots,a[n]\)，其前缀和数列\(S[i]\)定义为前i项的和，即\(S[i] = a[1]+a[2]+\cdots+a[i]\)，其中\(i = 1,2,\cdots,n\)。
     *     特别地，\(S[0]=0\)，它表示空序列的和。
     * </p>
     *
     * <p>
     *     应用场景：
     *         - 快速计算区间和：这是前缀和最主要的应用之一。这种方法避免了每次计算区间和时都对区间内的元素进行遍历，大大提高了计算效率。
     *         - 解决一些具有区间性质的问题：在一些统计问题中，需要频繁地计算不同区间内元素的和，使用前缀和可以将时间复杂度从每次计算的\(O(n)\)降低到\(O(1)\)，从而提高整个算法的效率。
     * </p>
     *
     * 该问题中，上三角和下三角其实就是除当前元素外的其他元素列表，利用前缀和的思想，使用前缀积，可以将乘法的项进行递增，以减少计算量。
     *
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = 1;
        }

        int tempNm = 1;
        for (int i = 1; i < nums.length; i++) {
            tempNm *= nums[i - 1];
            ans[i] *= tempNm;
        }

        tempNm = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            tempNm *= nums[i + 1];
            ans[i] *= tempNm;
        }

        return ans;
    }

}