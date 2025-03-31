package _2025._hot100._20250331;

/**
 * 接雨水
 *
 * @author 佳叙
 * @date 2025/3/31
 * @description <a href="https://leetcode.cn/problems/trapping-rain-water/description/"/>
 */
public class _42_traping_rain_water {

    /**
     * Two pointer. Same direction.
     *
     * <p>
     *     核心是在指针移动过程中，维护左右分别的最大高度，小于最大高度则积水，高于最大高度则更新最大高度。
     *     双指针可以确保最终相会的时候找到的柱子，一定是最高的。
     * </p>
     *
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int left  = 0;
        int right = height.length - 1;

        int leftMax  = 0;
        int rightMax = 0;

        int area = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] < leftMax) {
                    area += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            }
            else {
                if (height[right] < rightMax) {
                    area += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }

        return area;
    }

}