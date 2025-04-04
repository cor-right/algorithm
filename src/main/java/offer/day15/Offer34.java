package offer.day15;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @code https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=108mt86
 *
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
 */
public class Offer34 {

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
        if (root == null) {
            return new ArrayList<>();
        }


        return search(root, target, new ArrayList<>(), new ArrayList<>(), 0);
    }

    private List<List<Integer>> search(TreeNode curNode, int target, List<List<Integer>> resultList, ArrayList<Integer> partList, int sum) {
        sum += curNode.val;
        partList.add(curNode.val);

        if (isLeaf(curNode)) {
            if (sum == target) {
                resultList.add(new ArrayList<>(partList));
            }
            partList.remove(partList.size() - 1);
            return resultList;
        }

        if (curNode.left != null) {
            search(curNode.left, target, resultList, partList, sum);
        }
        if (curNode.right != null) {
            search(curNode.right, target, resultList, partList, sum);
        }

        partList.remove(partList.size() - 1);
        return resultList;
    }

    private boolean isLeaf(TreeNode root) {
        if (root == null) {
            return false;
        }
        return root.left == null && root.right == null;
    }

}
