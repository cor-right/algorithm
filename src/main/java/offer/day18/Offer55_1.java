package offer.day18;

/**
 * @code https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=108mt86
 *
 * 剑指 Offer 55 - I. 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 *
 *
 * 提示：
 *
 * 节点总数 <= 10000
 *
 */
public class Offer55_1 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    private int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        searchDepth(root, 0);
        return maxDepth;
    }

    private void searchDepth(TreeNode curNode, int depth) {
        if (curNode == null) {
            return ;
        }

        if (++depth > maxDepth) {
            maxDepth = depth;
        }

        searchDepth(curNode.left, depth);
        searchDepth(curNode.right, depth);
    }

}
