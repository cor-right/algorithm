package offer.day7;

/**
 * @code https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=108mt86
 *
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
 */
public class Offer26 {

  private class TreeNode {

      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     * 二叉树遍历，然后列表匹配，列表需要存储Null元素
     *
     * 列表匹配可以替换成逐个节点判断子树，节约空间
     */
    public static boolean isSubStructure(TreeNode a, TreeNode b) {
      if (b == null || a == null) {
        return false;
      }

      return hit(a, b) || isSubStructure(a.left, b) || isSubStructure(a.right, b);
    }

    public static boolean hit(TreeNode a, TreeNode b) {
      if (b == null) {
        return true;
      }
      if (a == null) {
        return false;
      }

      if (a.val != b.val) {
        return false;
      }

      return hit(a.left, b.left) && hit(a.right, b.right);
    }

}
