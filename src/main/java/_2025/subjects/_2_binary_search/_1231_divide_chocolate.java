package _2025.subjects._2_binary_search;

/**
 * 分享巧克力
 *
 * <p>
 *     你有一大块巧克力，它由一些甜度不完全相同的小块组成。我们用数组 sweetness 来表示每一小块的甜度。
 *     你打算和 K 名朋友一起分享这块巧克力，所以你需要将切割 K 次才能得到 K+1 块，每一块都由一些 连续 的小块组成。
 *     为了表现出你的慷慨，你将会吃掉 总甜度最小 的一块，并将其余几块分给你的朋友们。
 *     请找出一个最佳的切割策略，使得你所分得的巧克力 总甜度最大，并返回这个 最大总甜度。
 * </p>
 * @author 佳叙
 * @date 2025/4/1
 * @description <a href="https://leetcode.cn/problems/divide-chocolate/description/"/>
 */
public class _1231_divide_chocolate {

    /**
     * 和 410 真的很像啊，还是子数组的和的最大值的问题，这次是希望数组的和尽量大，数量固定
     *
     * @param sweetness
     * @param k
     * @return
     */
    public int maximizeSweetness(int[] sweetness, int k) {
        int right = 0;
        int left  = 0;

        for (int sweet : sweetness) {
            right += sweet;
            left = Math.min(left, sweet);
        }

        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            if (satisfy(sweetness, mid, k)) {
                left = mid;
            }
            else {
                right = mid - 1;
            }
        }

        return left;
    }

    private boolean satisfy(int[] sweetness, int max, int k) {
        int cnt = 0;
        int sum = 0;

        for (int sweet : sweetness) {
            sum += sweet;

            if (sum >= max) {
                sum = 0;
                cnt++;
            }
        }

        return cnt >= k;
    }

}