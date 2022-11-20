package hot100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *  
 *
 * Constraints:
 *
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Hot15_binarySearch_TE {


    /**
     * 三数之和 == 0，排序，二分查找，超时，O^2logn
     *
     * 第三个元素，以边界出发，可以二分查找，以第三个元素出发，收缩边界。
     *
     * -2 -1 -1 0 1 2 3 5
     *
     * -2 5，need -3，一定找不到
     * -2 3， need -1
     * -2 2，need 0
     * -1 2 need -1
     *
     * 从两边找，
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {

        quickSort(nums);

        Set<List<Integer>> results = new HashSet<>();

        int head = 0;
        int tail = nums.length - 1;

        loop(results, nums, head, tail);

        return new ArrayList<>(results);

    }

    private static void loop(Set<List<Integer>> results, int[] nums, int head, int tail) {
        while (tail > head) {
            System.out.println(nums[head] + "  " + nums[tail]);
            int sum = nums[head] + nums[tail];

            if (contains(nums, head + 1, tail - 1, sum * -1)) {
                List<Integer> singleRes = new ArrayList<>(3);
                singleRes.add(nums[head]);
                singleRes.add(sum * -1);
                singleRes.add(nums[tail]);
                results.add(singleRes);
            }

            if (sum > 0 && nums[head + 1] > sum * -1) {
                tail--;
            }
            else if (sum < 0 && nums[tail - 1] < sum * -1) {
                head++;
            }
            else {
                loop(results, nums, head + 1, tail);
                loop(results, nums, head, tail - 1);
                head++;
                tail--;
            }

        }
    }

    private static boolean contains(int[] nums, int left, int right, int target) {

        int head = left;
        int tail = right;

        int mid = (head + tail) / 2;

        while (head <= tail) {
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                tail = mid - 1;
                mid = (head + tail) / 2;
            } else {
                head = mid + 1;
                mid = (head + tail) / 2;
            }
        }

        return false;
    }

    private static void quickSort(int[] nums) {
        sortCore(nums, 0, nums.length - 1);
    }

    private static void sortCore(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int base = nums[start];

        int head = start;
        int tail = end;
        while (head < tail) {
            while (nums[tail] >= base && tail > head) {
                tail--;
            }
            nums[head] = nums[tail];
            while (nums[head] <= base && head < tail) {
                head++;
            }
            nums[tail] = nums[head];
        }
        nums[head] = base;

        sortCore(nums, start, head - 1);
        sortCore(nums, head + 1, end);
    }

    public static void main(String[] args) {
        int[] ints = {34,55,79,28,46,33,2,48,31,-3,84,71,52,-3,93,15,21,-43,57,-6,86,56,94,74,83,-14,28,-66,46,-49,62,-11,43,65,77,12,47,61,26,1,13,29,55,-82,76,26,15,-29,36,-29,10,-70,69,17,49};
        System.out.println(threeSum(ints));
    }


}
