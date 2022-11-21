package offer.day2;

import jdk.javadoc.internal.doclets.formats.html.markup.Head;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 题目地址
 * @code https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=108mt86
 *
 * 剑指 Offer 35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 *
 *
 *
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 *
 *
 *
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 *
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *
 *
 * 提示：
 *
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 */
public class Offer35 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 问题的难点，在于如何知道random指向节点的索引。
     *
     * 简单做，可以直接先遍历一遍列表，将所有节点存储起来。
     *
     * 复杂做，可以先将新老链表的节点，从 旧 -> 新 -> 旧 -> 新 的方式拼接。
     *
     * 复杂做本质也是要先遍历一遍列表的，区别只在于优化了空间复杂度，将从哈希表中取数的逻辑，改成了从链表中取数而已。
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();

        Node newHead = new Node(head.val);

        Node newNode = newHead;
        Node oldNode = head;
        while (oldNode != null) {
            map.put(oldNode, newNode);
            newNode.next = oldNode.next == null ? null : new Node(oldNode.next.val);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }

        newNode = newHead;
        while (head != null) {
            newNode.random = map.get(head.random);
            head = head.next;
            newNode = newNode.next;
        }

        return newHead;

    }

}
