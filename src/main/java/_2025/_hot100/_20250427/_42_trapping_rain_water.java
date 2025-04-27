package _2025._hot100._20250427;

/**
 * 接雨水
 *
 * @author 佳叙
 * @date 2025/4/27
 * @description <a href=""/>
 */
public class _42_trapping_rain_water {

    /**
     *
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int lb  = 0;
        int rb = 0;

        int left  = 0;
        int right = height.length - 1;

        int capability = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                capability += Math.max(0, lb - height[left]);
                lb = Math.max(lb, height[left]);

                left++;
            }
            else {
                capability += Math.max(0, rb - height[right]);
                rb = Math.max(rb, height[right]);

                right--;
            }
        }

        return capability;
    }

}