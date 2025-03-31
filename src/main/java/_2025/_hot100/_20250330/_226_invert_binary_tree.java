package _2025._hot100._20250330;

/**
 * @author 佳叙
 * @date 2025/3/30
 * @description <a href="https://leetcode.cn/problems/invert-binary-tree/description/"/>
 */
public class _226_invert_binary_tree {

    /**
     * Recursion.
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }


        root.left  = invertTree(root.left);
        root.right = invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
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