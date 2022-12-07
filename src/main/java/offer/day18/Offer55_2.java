package offer.day18;

/**
 * @code https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=108mt86
 *
 * 剑指 Offer 55 - II. 平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 *
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 *
 *
 * 限制：
 *
 * 0 <= 树的结点个数 <= 10000
 */
public class Offer55_2 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }


    /**
     任意节点的左右子树的高度差不大于1，求深度用递归，
     */
    public boolean isBalanced(TreeNode root) {
        try {
            findDepth(root);
            return true;
        } catch(RuntimeException ex) {
            return false;
        }
    }

    private int findDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = findDepth(node.left);
        int rightDepth = findDepth(node.right);

        if (leftDepth - rightDepth < -1 || leftDepth - rightDepth > 1) {
            throw new RuntimeException();
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }

}
