package _2025.subjects._15_dp_2d_2;

/**
 * 石子游戏
 *
 * @author 佳叙
 * @date 2025/4/11
 * @description <a href="https://leetcode.cn/problems/stone-game/description/"/>
 */
public class _877_stone_game {

    /**
     * Sub array
     *
     * @param piles
     * @return
     */
    public boolean stoneGame(int[] piles) {
        return stoneGameWithRecursion(piles);
    }

    private boolean stoneGameWithRecursion(int[] piles) {
        return maximumScore(piles, 0, piles.length - 1, new int[piles.length][piles.length]) > 0;
    }

    private int maximumScore(int[] piles, int left, int right, int[][] memo) {
        if (left == right) {
            return piles[left];
        }

        if (memo[left][right] != 0) {
            return memo[left][right];
        }

        return memo[left][right] =
                Math.max(piles[left] - maximumScore(piles, left + 1, right, memo), piles[right] - maximumScore(piles, left, right - 1, memo));
    }

}