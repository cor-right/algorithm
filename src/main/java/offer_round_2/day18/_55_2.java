package offer_round_2.day18;

/**
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
public class _55_2 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        return depth(root, 0) != -1;
    }

    private int depth(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        int ld = depth(node.left, depth + 1);
        if (ld == -1) {
            return -1;
        }

        int rd = depth(node.right, depth + 1);
        if (rd == -1) {
            return -1;
        }

        return Math.abs(ld - rd) < 2 ? Math.max(ld, rd) : -1;
    }

}
