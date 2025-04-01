package _2025.subjects._2_binary_search;

/**
 * 在 D 天内送达包裹的能力
 *
 * <p>
 *     传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
 *     传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *     返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
 * </p>
 * @author 佳叙
 * @date 2025/4/2
 * @description <a href="https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/description/"/>
 */
public class _1011_capacity_to_ship_packages_within_d_days {

    /**
     * 二分查找，搜索的区间就是船的运载能力。
     *
     * @param weights
     * @param days
     * @return
     */
    public int shipWithinDays(int[] weights, int days) {
        int left  = 0;
        int right = 0;

        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        // To find min capacity, need the left boundary
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (ableToShip(weights, days, mid)) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean ableToShip(int[] weights, int days, int max) {
        int sum = 0;
        int day = 1;

        for (int weight : weights) {
            sum += weight;

            if (sum > max) {
                day++;
                sum = weight;
            }
        }

        return day <= days;
    }

}