package _2025.subjects._2_binary_search;

/**
 * 找距离最近的数
 *
 * @author 佳叙
 * @date 2025/4/1
 * @description <a href=""/>
 */
public class Template_3 {

    public static void main(String[] args) {
        int[] range = new int[] {0, 0, 0, 1, 4, 4, 5, 6, 7};
        System.out.println(new Template_3().findClosest(range, 2));
        System.out.println(new Template_3().findClosest(range, 3));
        System.out.println(new Template_3().findClosest(range, 4));
    }

    private int findClosest(int[] range, int target) {

        int left  = 0;
        int right = range.length - 1;


        while (right - left > 1) {
            int mid = left + (right - left + 1) / 2;

            if (target < range[mid]) {
                right = mid;
            }
            else {
                left = mid;
            }
        }

        if (target < range[left]) {
            return left;
        }
        if (target > range[right]) {
            return right;
        }
        return target - range[left] <= range[right] - target ? left : right;

    }


}