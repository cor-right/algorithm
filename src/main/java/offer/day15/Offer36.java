package offer.day15;

/**
 * @code https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=108mt86
 *
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 *
 *
 * 为了让您更好地理解问题，以下面的二叉搜索树为例：
 *
 *
 *
 *
 *
 *
 *
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 *
 * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
 *
 *
 *
 *
 *
 *
 *
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 *
 *
 *
 * 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 *
 * 注意：此题对比原题有改动。
 */
public class Offer36 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    // 成员变量不会存储到局部变量表，可以增加堆栈的深度
    private Node head = null;
    private Node pre  = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    /**
     * 左中右，中序遍历
     *
     * 到后一个结点的时候，队前一个节点与当前节点的引用进行调整
     *
     * @param curNode
     */
    private void dfs(Node curNode) {
        if (curNode == null) {
            return ;
        }

        dfs(curNode.left);

        if (pre == null) {
            head = curNode;
        } else {
            pre.right = curNode;
            curNode.left = pre;
        }
        pre = curNode;

        dfs(curNode.right);
    }




}
