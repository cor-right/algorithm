package _2025.subjects._16_dp_2d_3;

/**
 * 鸡蛋掉落
 *
 * @author 佳叙
 * @date 2025/4/20
 * @description <a href="https://leetcode.cn/problems/super-egg-drop/description/"/>
 */
public class _887_super_egg_drop {

    /**
     * 给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。
     * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。
     * 每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
     * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
     *
     * @param k
     * @param n
     * @return
     */
    public int superEggDrop(int k, int n) {
        return traversal(new Integer[n + 1][k + 1], k, n);
    }

    private int traversal(Integer[][] memo, int k, int n) {
        if (n == 0) {
            return 0;
        }
        if (k == 1) {
            return n;
        }

        if(memo[n][k] != null) {
            return memo[n][k];
        }

        int left  = 1;
        int right = n;

        while (right - left > 1) {
            int mid = left + (right - left + 1) / 2;

            int increasing = traversal(memo, k - 1,  mid);
            int decreasing = traversal(memo, k, n - mid);

            if (increasing > decreasing) {
                right = mid;
            }
            else {
                left = mid;
            }
        }

        return memo[n][k] = Math.min(
                Math.max(traversal(memo, k - 1, left), traversal(memo, k, n - left)) + 1,
                Math.max(traversal(memo, k - 1, right), traversal(memo, k, n - right)) + 1
        );
    }


}