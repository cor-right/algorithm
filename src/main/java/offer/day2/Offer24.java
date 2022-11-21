package offer.day2;

import java.util.Stack;

/**
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 *
 * 原理就是调换两两节点之间指针的指向。
 *
 */
public class Offer24 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 双指针，推荐
     *
     * @param head
     * @return
     */
    public ListNode reverseListDoublePointer(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head, pre = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    /**
     * 辅助栈，本质和递归相同，空间复杂度会高一点，代码会复杂一点
     *
     * @param head
     * @return
     */
    public ListNode reverseListStack(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        head = stack.peek();
        while (!stack.empty()) {
            ListNode curNode = stack.pop();
            curNode.next = stack.empty() ? null : stack.peek();
        }

        return head;
    }



}
