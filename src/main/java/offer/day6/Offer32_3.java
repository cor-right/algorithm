package offer.day6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @code https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=108mt86
 *
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
 */
public class Offer32_3 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    /**
     * 依然是层次遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> resList = new ArrayList<>();

        Queue<TreeNode> nodes = new LinkedList<TreeNode>() {{add(root);}};

        boolean flag = true;
        while (!nodes.isEmpty()) {
            int len = nodes.size();

            LinkedList<Integer> res = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                TreeNode poll = nodes.poll();
                if (flag) {
                    res.addLast(poll.val);
                } else {
                    res.addFirst(poll.val);
                }

                if (poll.left != null) {
                    nodes.add(poll.left);
                }
                if (poll.right != null) {
                    nodes.add(poll.right);
                }
            }

            flag = !flag;
            if (!res.isEmpty()) {
                resList.add(res);
            }
        }

        return resList;
    }

}
