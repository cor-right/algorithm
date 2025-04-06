package _2025.subjects._10_graph_bfs_2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 零钱兑换
 *
 * <p>
 *     这题当然可以用动态规划来解决，不过这里我想尝试一下用图的 BFS 解决，就是这个空间复杂度会高一些
 * </p>
 *
 * @author 佳叙
 * @date 2025/4/6
 * @description <a href="https://leetcode.cn/problems/coin-change/description/"/>
 */
public class _322_coin_charge {

    /**
     * [1, 2, 5], 100 这个case超时了，意料之中吧，代码倒是没啥问题，这是一个通用的 BFS 结构
     *
     * 该问题本质上是一个动态规划问题，存在最优子结构性质。BFS 只是一种通用的搜索策略，没有利用到问题中关于最优解的递推关系。
     * 动态规划可以通过记录子问题的解，避免重复计算，从而更高效地解决问题。
     * 例如，计算凑成金额 x 的最少硬币数时，可能会依赖于已经计算出的凑成小于 x 的金额的最少硬币数，动态规划可以直接利用这些已有的结果。
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        // a[0] == amount, a[1] == coins number.
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int coin : coins) {
            queue.offer(new int[] {coin, 1});
        }

        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int curAmount = data[0];
            int curCount  = data[1];

            if (curAmount == amount) {
                return curCount;
            }

            for (int coin : coins) {
                int nextAmount = curAmount + coin;

                if (nextAmount <= amount) {
                    queue.offer(new int[] {nextAmount, curCount + 1});
                }
            }
        }

        return -1;
    }

}