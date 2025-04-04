package offer_round_2.day7;

/**
 * 剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 *
 * 0 <= 节点个数 <= 10000
 *
 * 通过次数296,296提交次数637,365
 * 请问您在哪类招聘中遇到此题？
 */
public class _26 {


    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        return recursion(A, B, B);
    }

    private boolean recursion(TreeNode mainNode, TreeNode subNode, TreeNode subHead) {
        if (mainNode == null && subNode != null) {
            return false;
        }

        if (subNode == null) {
            return true;
        }

        if (mainNode.val == subNode.val) {
            return (recursion(mainNode.left, subNode.left, subHead) && recursion(mainNode.right, subNode.right, subHead)) ||
                    recursion(mainNode.left, subHead, subHead) ||
                    recursion(mainNode.right, subHead, subHead);
        }
        else {
            return recursion(mainNode.left, subHead, subHead) || recursion(mainNode.right, subHead, subHead);
        }
    }
}
