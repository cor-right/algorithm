package offer.day6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @code https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=108mt86
 *
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
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
 * 返回：
 *
 * [3,9,20,15,7]
 *
 *
 * 提示：
 *
 * 节点总数 <= 1000
 *
 */
public class Offer32 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    /**
     * 二叉树层次遍历
     *
     * @param root
     * @return
     */
    public static int[] levelOrder(TreeNode root) {

        if (root == null) {
            return new int[]{};
        }


        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);

        List<Integer> list = new ArrayList<>();
        while (!nodesQueue.isEmpty()) {
            TreeNode poll = nodesQueue.poll();
            list.add(poll.val);

            if (poll.left != null) {
                nodesQueue.add(poll.left);
            }
            if (poll.right != null) {
                nodesQueue.add(poll.right);
            }
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;

    }

}
