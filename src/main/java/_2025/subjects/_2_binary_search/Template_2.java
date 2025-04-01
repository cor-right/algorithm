package _2025.subjects._2_binary_search;

/**
 * 首次出现或最后一次出现的位置
 *
 * @author 佳叙
 * @date 2025/4/1
 * @description <a href=""/>
 */
public class Template_2 {

    public static void main(String[] args) {
        int[] range = new int[] {0, 0, 0, 2, 2, 2, 3, 4, 5, 6, 7};
        System.out.println(new Template_2().findFirst(range, 2));
        System.out.println(new Template_2().findFirst(range, 1));
        System.out.println(new Template_2().findLast(range, 2));
        System.out.println(new Template_2().findLast(range, 1));
    }


    /**
     * 向左找时，保留当前 mid 元素，避免丢失潜在答案
     *
     * <p>
     * 1. left < right，而不是 left <= right，是为了确保每次执行时，区间都有缩减，不然可能在向左寻找数据时陷入死循环
     * 2. 不加 1 的情况：mid = left + (right - left) / 2
     *    - 作用：当区间长度为偶数时，mid会偏向左侧。
     *    - 适用场景：当需要向左搜索或排除右端点时使用。
     * </p>

     * @param range
     * @param target
     * @return
     */
    private int findFirst(int[] range, int target) {
        int left  = 0;
        int right = range.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (target <= range[mid]) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     *
     * @param range
     * @param target
     * @return
     */
    private int findLast(int[] range, int target) {
        int left  = 0;
        int right = range.length - 1;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            if (target < range[mid]) {
                right = mid - 1;
            }
            else {
                left = mid;
            }
        }

        return right;
    }


}