package hot100;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 *  
 *
 * Constraints:
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Hot11 {

    /**
     * 双指针
     *
     *
     * 面积公式 S(i, j) = min(h[i], h[j]) * (j - i)
     *
     * 水位取决于短板，所以要使短板尽可能长。
     *
     *
     *
     *
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;

        int maxVal = 0;
        while (leftIndex < rightIndex) {
            maxVal = Math.max(area(height, leftIndex, rightIndex), maxVal);

            if (height[leftIndex] <= height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }

        }
        return maxVal;
    }

    private static int area(int[] height, int left, int right) {
        return Math.min(height[left], height[right]) * (right - left);
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {1,3,2,5,25,24,5}));
    }
}
