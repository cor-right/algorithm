package _2025.subjects._1_two_pointers;

/**
 * 盛最多水的容器
 *
 * @author 佳叙
 * @date 2025/3/31
 * @description <a href="https://leetcode.cn/problems/container-with-most-water/description/"/>
 */
public class _11_container_with_most_water {

    /**
     * Two pointer. Different direction.
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int area = Math.min(height[l], height[r]) * (r - l);
        while (l < r) {
            if (height[l] < height[r]) {
                l++;
            }
            else {
                r--;
            }

            area = Math.max(Math.min(height[l], height[r]) * (r - l), area);
        }

        return area;
    }

}