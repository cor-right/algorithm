package offer_round_2.day7;

/**
 * 剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 */
public class _27 {

    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode node = new TreeNode(root.val);
        recursion(root, node);

        return node;
    }

    private void recursion(TreeNode oriNode, TreeNode tarNode) {
        if (oriNode.left != null) {
            tarNode.right = new TreeNode(oriNode.left.val);
            recursion(oriNode.left, tarNode.right);
        }
        if (oriNode.right != null) {
            tarNode.left = new TreeNode(oriNode.right.val);
            recursion(oriNode.right, tarNode.left);
        }
    }

}
