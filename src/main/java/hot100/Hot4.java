package hot100;

import java.util.Arrays;

public class Hot4 {

    /**
     * O(m+n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = null;

        if (nums1 == null || nums1.length == 0) {
            arr = nums2;
        }
        if (nums2 == null || nums2.length == 0) {
            arr = nums1;
        }

        if (arr == null) {
            int index1 = 0;
            int index2 = 0;
            int allCount = nums1.length + nums2.length;
            arr = new int[allCount];
            for (int i = 0; i < nums1.length + nums2.length; i++) {
                if (index1 >= nums1.length) {
                    arr[i] = nums2[index2++];
                } else if (index2 >= nums2.length) {
                    arr[i] = nums1[index1++];
                } else {
                    if (nums1[index1] <= nums2[index2]) {
                        arr[i] = nums1[index1++];
                    } else {
                        arr[i] = nums2[index2++];
                    }
                }
            }
        }

        if (arr.length == 1) {
            return arr[0];

        } else if (arr.length % 2 == 0) {
            return (arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2.0;

        } else {
            return arr[(int) Math.floor(arr.length / 2)];
        }

    }


}
