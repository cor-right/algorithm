package offer_round_2.day6;

import java.util.*;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 *
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 *
 * 提示：
 *
 * 节点总数 <= 1000
 * 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * 通过次数268,406提交次数389,394
 *
 */
public class _32_2 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<TreeNode> curNodeList  = new ArrayList<>();
        curNodeList.add(root);

        List<List<Integer>> resultList = new ArrayList<>();

        while (!curNodeList.isEmpty()) {
            List<TreeNode> levelNodesList = new ArrayList<>();
            List<Integer> levelResultList = new ArrayList<>();

            for (TreeNode treeNode : curNodeList) {
                levelResultList.add(treeNode.val);

                if (treeNode.left != null) {
                    levelNodesList.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    levelNodesList.add(treeNode.right);
                }
            }

            curNodeList = levelNodesList;
            resultList.add(levelResultList);

        }

        return resultList;
    }

}
