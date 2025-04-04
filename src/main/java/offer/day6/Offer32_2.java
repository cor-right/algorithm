package offer.day6;

import java.util.*;

/**
 * @code https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=108mt86
 *
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
 *
 *
 *
 */
public class Offer32_2 {

    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     * 仍然是二叉树层次遍历
     *
     * 重点在于分组，
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
       if (root == null) {
           return new ArrayList<>();
       }

       Queue<TreeNode> nodes = new LinkedList<TreeNode>() {{add(root);}};

       List<List<Integer>> resList = new ArrayList<>();
       while (!nodes.isEmpty()) {
           List<Integer> list = new ArrayList<>();

           int size = nodes.size();
           for (int i = 0; i < size; i++) {
               TreeNode poll = nodes.poll();
               list.add(poll.val);
               if (poll.left != null) {
                   nodes.add(poll.left);
               }
               if (poll.right != null) {
                   nodes.add(poll.right);
               }
           }

           if (!list.isEmpty()) {
               resList.add(list);
           }
       }

       return resList;

    }

}
