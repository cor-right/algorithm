package offer_round_2.day6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
 *   [20,9],
 *   [15,7]
 * ]
 *
 *
 * 提示：
 *
 * 节点总数 <= 1000
 * 通过次数248,030提交次数425,663
 */
public class _32_3 {


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


        boolean reverse = false;

        List<TreeNode> queue = new ArrayList<TreeNode>() {{add(root);}};

        List<List<Integer>> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            List<TreeNode> nextLevelNodes = new ArrayList<>();
            LinkedList<Integer> levelResList = new LinkedList<>();

            for (TreeNode node : queue) {
                if (reverse) {
                    levelResList.addFirst(node.val);
                } else {
                    levelResList.addLast(node.val);
                }

                if (node.left != null) nextLevelNodes.add(node.left);
                if (node.right != null) nextLevelNodes.add(node.right);
            }

            result.add(levelResList);

            if (nextLevelNodes.isEmpty()) {
                break;
            }

            reverse = !reverse;
            queue = nextLevelNodes;

        }

        return result;
    }

}
