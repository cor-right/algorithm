package offer_round_2.day15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 *
 *
 * 提示：
 *
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 * 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/
 */
public class _34 {

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


    public List<List<Integer>> pathSum(TreeNode root, int target) {
        return search(new ArrayList<>(), new Stack<>(), root, target, 0);
    }


    private List<List<Integer>> search(List<List<Integer>> resultList, Stack<Integer> path, TreeNode node, int target, int current) {
        if (node == null) {
            return resultList;
        }

        current += node.val;

        path.push(node.val);

        if (node.left == node.right && node.left == null) {
            if (current == target) {
                resultList.add(new ArrayList<>(path));
            }
            path.pop();
            return resultList;
        }

        if (node.left != null) {
            search(resultList, path, node.left, target, current);
        }
        if (node.right != null) {
            search(resultList, path, node.right, target, current);
        }

        path.pop();
        return resultList;
    }


}
