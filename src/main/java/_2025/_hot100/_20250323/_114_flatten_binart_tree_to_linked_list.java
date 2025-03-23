package _2025._hot100._20250323;

/**
 * 二叉树展开为单链表
 *
 * @author 佳叙
 * @date 2025/3/23
 * @description <a href="https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/"/>
 */
public class _114_flatten_binart_tree_to_linked_list {


    /**
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     * - 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * - 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     *
     * <p>
     *     inorder traversal.
     * </p>
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        TreeNode node = root;

        while (node != null) {
            if (node.left != null) {
                TreeNode beforeRight = node.right;

                node.right = node.left;
                node.left = null;

                TreeNode temp = node;
                while (temp.right != null) {
                    temp = temp.right;
                }

                temp.right = beforeRight;
            }

            node = node.right;
        }
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