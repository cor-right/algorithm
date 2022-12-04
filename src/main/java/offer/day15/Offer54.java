package offer.day15;

/**
 * @code https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=108mt86
 *
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 *
 *
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *
 *
 * 限制：
 *
 * 1 ≤ k ≤ 二叉搜索树元素个数
 */
public class Offer54 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    private int curOrder = 0;
    private Integer result = null;
    private int theK = 0;

    /*
    右中左，第K个数
     */
    public int kthLargest(TreeNode root, int k) {
        theK = k;
        dfs(root);

        return result == null ? 0 : result;
    }

    private void dfs(TreeNode node) {
        if (node == null || result != null) {
            return ;
        }

        dfs(node.right);

        if (theK == ++curOrder) {
            result = node.val;
            return ;
        }

        if (result != null) {
            return ;
        }

        dfs(node.left);

    }
}
