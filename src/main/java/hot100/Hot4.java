package hot100;

import java.util.Arrays;

/**
 * 核心是：二分查找
 */
public class Hot4 {

    /**
     * O(m+n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArraysSlow(int[] nums1, int[] nums2) {
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

    /**
     *
     * 计算第K小数的问题，K是中位数的下标。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArraysFast(int[] nums1, int[] nums2) {

        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            int[] nums = nums1 == null || nums1.length == 0 ? nums2 : nums1;

            if (nums == null || nums.length == 0) {
                return 0;
            }

            if (nums.length % 2 == 0) {
                return (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.0;
            } else {
                return nums[nums.length / 2];
            }
        }

        int midLeft = (nums1.length + nums2.length + 1) / 2;
        int midRight = (nums1.length + nums2.length + 2) / 2;

        return  (findLoop(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, midLeft)
                + findLoop(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, midRight))
                / 2.0;

    }

    /**
     *
     * 101个数，则是第55小的数
     *
     * 二分找临界，分别排除 55*1/2，55*1/4，55*1/8个数等等，不断逼近临界值。
     *
     *
     * // k - 1 代表下标
     * // leftBound代表数组的开始
     * // leftBound + k - 1 代表目标
     *
     * @param arrA
     * @param leftBoundA index
     * @param rightBoundA index
     * @param arrB
     * @param leftBoundB
     * @param rightBoundB
     * @param k 1 ~ n,
     * @return
     */
    private static double findLoop(int[] arrA, int leftBoundA, int rightBoundA,
                                   int[] arrB, int leftBoundB, int rightBoundB,
                                   int k) {
        int lengthA = rightBoundA - leftBoundA + 1; // +1是因为这是下标
        int lengthB = rightBoundB - leftBoundB + 1;

        if (lengthA > lengthB) {
            return findLoop(arrB, leftBoundB, rightBoundB, arrA, leftBoundA, rightBoundA, k);
        }

        if (lengthA == 0) {
            return arrB[leftBoundB + k - 1];
        }

        if (k == 1) {
            return Math.min(arrA[leftBoundA], arrB[leftBoundB]);
        }

        // 左界 + 可用剩余长度和K/2的最小值
        int ia = leftBoundA + (Math.min(k / 2, lengthA)) - 1;
        int ib = leftBoundB + (Math.min(k / 2, lengthB)) - 1;

        if (arrA[ia] <= arrB[ib]) {
            return findLoop(arrA, ia + 1, rightBoundA, arrB, leftBoundB, rightBoundB, k - (Math.min(k / 2, lengthA)));
        } else {
            return findLoop(arrA, leftBoundA, rightBoundA, arrB, ib + 1, rightBoundB, k - (Math.min(k / 2, lengthB)));
        }

    }

//    public static void main(String[] args) {
//
//        // k: 2,
//        System.out.println(findMedianSortedArraysFast(new int[] {0, 0, 0, 0, 0}, new int[] {-1,0,0,0,0,0,1}));
//    }



}
