package _2025.subjects._8_tree_dfs;

/**
 * 求根节点到叶节点的数字之和
 *
 * @author 佳叙
 * @date 2025/4/4
 * @description <a href="https://leetcode.cn/problems/sum-root-to-leaf-numbers/"/>
 */
public class _129_sum_root_to_leaf_numbers {

    private int sum = 0;

    /**
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        recursion(root, 0);
        return sum;
    }

    private void recursion(TreeNode node, int prefix) {
        if (node == null) {
            return ;
        }

        prefix = prefix * 10 + node.val;
        recursion(node.left, prefix);
        recursion(node.right, prefix);

        if (node.left == null && node.right == null) {
            sum += prefix;
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