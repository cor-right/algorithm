package _2025._hot100._20250323;

import java.util.Arrays;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * @author 佳叙
 * @date 2025/3/23
 * @description <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/"/>
 */
public class _105_construct_binary_tree_from_preorder_and_inorder_traversal {


    /**
     * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * preorder: middle, left, right
     * inorder:  left, middle, right
     *
     * The right part length always same. Needs to find out the left and right part.
     *
     * @param preorder
     * @param preStart
     * @param preEnd
     * @param inorder
     * @param inStart
     * @param inEnd
     * @return
     */
    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode();
        node.val = preorder[preStart];

        int index = inStart;
        while (inorder[index] != preorder[preStart]) {
            index++;
        }
        int leftPartLen = index - inStart;

        node.left  = buildTree(preorder, preStart + 1, preStart + leftPartLen, inorder, inStart, index - 1);
        node.right = buildTree(preorder, preStart + 1 + leftPartLen, preEnd, inorder, index + 1, inEnd);

        return node;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.binarySearch(new int[]{1, 1, 2, 3, 1, 1}, 6));
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}