package _2025.subjects._8_tree_dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 路经总和 Ⅱ
 *
 * @author 佳叙
 * @date 2025/4/5
 * @description <a href="https://leetcode.cn/problems/path-sum-ii/"/>
 */
public class _113_path_sum_2 {

    /**
     *
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        recursion(root, ans, new ArrayList<>(), 0, targetSum);
        return ans;
    }

    /**
     *
     * @param node
     * @param ans
     * @param path
     * @param target
     */
    private void recursion(TreeNode node, List<List<Integer>> ans, List<Integer> path, int sum, int target) {
        if (node == null) {
            return ;
        }

        sum += node.val;
        path.add(node.val);

        if (node.left == null && node.right == null && sum == target) {
            ans.add(new ArrayList<>(path));
        }

        if (node.left != null) {
            recursion(node.left, ans, path, sum, target);
        }
        if (node.right != null) {
            recursion(node.right, ans, path, sum, target);
        }

        path.remove(path.size() - 1);
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