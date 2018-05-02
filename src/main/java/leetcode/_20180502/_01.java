package leetcode._20180502;


/**
 * Created by Jiaxu_Zou on 2018-5-2
 *
 * Title :
 *     minimum-depth-of-binary-tree
 *
 * Description:
 *     Given a binary tree, find its minimum depth. The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Key Word :
 *     Tree
 *
 * Note :
 *     递归
 *     这里需要注意题目的说明，最小深度指的是距离最近叶节点的距离， 所以要注意对空节点的判断，这里之前掉进了坑里
 *
 * Link :
 *     https://www.nowcoder.com/practice/e08819cfdeb34985a8de9c4e6562e724?tpId=46&tqId=29030&tPage=1&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 */
public class _01 {

    // tree node define
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public int run(TreeNode root) {
        if (root == null)   // root == null
            return 0;
        else if (root.left == null && root.right == null)   // left child == right child == null
            return 1;
        else if (root.left == null || root.right == null)   // left child == null || right == null
            return root.left == null ? run(root.right) + 1: run(root.left) + 1;
        else    // left chile != null && right child != null
            return Math.min(run(root.left), run(root.right)) + 1;
    }



}
