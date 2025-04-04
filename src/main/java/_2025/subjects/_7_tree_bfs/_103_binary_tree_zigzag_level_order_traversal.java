package _2025.subjects._7_tree_bfs;

import java.util.*;
import java.util.function.Consumer;

/**
 * 二叉树的锯齿形层序遍历
 *
 * @author 佳叙
 * @date 2025/4/4
 * @description <a href="https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/"/>
 */
public class _103_binary_tree_zigzag_level_order_traversal {

    /**
     *
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 1;
        while (!queue.isEmpty()) {
            Deque<Integer> partAns = new ArrayDeque<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (level % 2 == 1) {
                    partAns.offerLast(node.val);
                } else {
                    partAns.offerFirst(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            ans.add(new ArrayList<>(partAns));
            level++;
        }

        return ans;
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