package offer.day20;

/**
 * @code https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=108mt86
 *
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 *
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 *
 * 示例 1:
 *
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * 示例 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 */
public class Offer07 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
    }

}
