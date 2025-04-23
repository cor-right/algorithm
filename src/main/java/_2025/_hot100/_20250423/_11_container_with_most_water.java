package _2025._hot100._20250423;

/**
 * 盛水最多的容器
 *
 * @author 佳叙
 * @date 2025/4/23
 * @description <a href="https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked"/>
 */
public class _11_container_with_most_water {

    /**
     *
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left  = 0;
        int right = height.length - 1;

        int max = 0;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));

            if (height[left] <= height[right]) {
                left++;
            }
            else {
                right--;
            }
        }

        return max;
    }

}