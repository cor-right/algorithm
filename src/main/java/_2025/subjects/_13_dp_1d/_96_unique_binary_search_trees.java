package _2025.subjects._13_dp_1d;

/**
 * 不同的二叉搜索树
 *
 * @author 佳叙
 * @date 2025/4/10
 * @description <a href=""/>
 */
public class _96_unique_binary_search_trees {

    /**
     * 子问题: 当前树的种类 = 左子树的种类 * 右子树的种类
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        return numTreesWithUpBottom(n);
    }

    /**
     * Bottom-Up: 从小到大，逐渐扩大规模
     *
     * @param n
     * @return
     */
    private int numTreesWithBottomUp(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i - 1; j++) {
                memo[i] += memo[j] * memo[i - j - 1];
            }
        }

        return memo[n];
    }

    /**
     * Up-Bottom: 从大到小，使用 Post-order 的方式来逐步获取较大规模的问题的解
     *
     * @param n
     * @return
     */
    private int numTreesWithUpBottom(int n) {
        return recursion(n, new int[n + 1]);
    }

    private int recursion(int size, int[] memo) {
        if (size <= 1) {
            return 1;
        }

        if (memo[size] != 0) {
            return memo[size];
        }

        int count = 0;
        for (int i = 0; i < size; i++) {
            count += recursion(i, memo) * recursion(size - i - 1, memo);
        }

        memo[size] = count;
        return count;
    }

}