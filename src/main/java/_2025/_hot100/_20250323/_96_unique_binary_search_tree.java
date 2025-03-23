package _2025._hot100._20250323;

/**
 * 96. 不同的二叉搜索树
 *
 * @author 佳叙
 * @date 2025/3/23
 * @description <a href="https://leetcode.cn/problems/unique-binary-search-trees/description/"/>
 */
public class _96_unique_binary_search_tree {

    /**
     * Using dynamic planning.
     * 卡特兰数（Catalan Number）：给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
     * - 在二叉搜索树中，每个节点的左子树中的所有节点的值都小于该节点的值，右子树中的所有节点的值都大于该节点的值。
     * - 因此，如果我们选择一个节点作为根节点，那么左子树和右子树的节点数就确定了。
     *
     * @param n
     * @return
     */
    public static int numTrees(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += (dp[j] * dp[i - j - 1]);
            }
        }

        return dp[n];
    }

//    public static void main(String[] args) {
//        System.out.println(numTrees(4));
//    }



}