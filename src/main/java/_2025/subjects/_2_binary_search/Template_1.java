package _2025.subjects._2_binary_search;

/**
 * @author 佳叙
 * @date 2025/3/31
 * @description <a href=""/>
 */
public class Template_1 {

    public static void main(String[] args) {
        System.out.println(new Template_1().binarySearch(new int[] {1, 2, 3, 5, 7, 9}, 5));
    }

    private int binarySearch(int[] arr, int k) {

        int left  = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == k) {
                return mid;
            }

            if (arr[mid] > k) {
                right = mid - 1;
            }
            else {
                left  = mid + 1;
            }
        }

        return -1;
    }




}