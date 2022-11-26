package offer.day7;

/**
 * @code https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=108mt86
 *
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
public class Offer27 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    /**
     * 前序遍历输入，后序遍历输出，得到反转的二叉树
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode mirror = new TreeNode(root.val);
        forwardSearchTree(root, mirror);
        return mirror;
    }

    /**
     * 从上向下
     *
     * @param ori
     * @param tar
     */
    public void forwardSearchTree(TreeNode ori, TreeNode tar) {
        if (ori == null) {
            return ;
        }

        if (ori.left != null) {
            tar.right = new TreeNode(ori.left.val);
            forwardSearchTree(ori.left, tar.right);
        }
        if (ori.right != null) {
            tar.left = new TreeNode(ori.right.val);
            forwardSearchTree(ori.right, tar.left);
        }
    }

    /**
     * 从上向下
     *
     * @param ori
     * @param tar
     */
    public void forwardSearchUseStack(TreeNode ori, TreeNode tar) {

    }

}
