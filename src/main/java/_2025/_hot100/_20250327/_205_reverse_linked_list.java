package _2025._hot100._20250327;

/**
 * 反转链表
 *
 * @author 佳叙
 * @date 2025/3/27
 * @description <a href="https://leetcode.cn/problems/reverse-linked-list/description/"/>
 */
public class _205_reverse_linked_list {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }



        ListNode preNode = head;
        ListNode curNode = head.next;


        while (curNode != null) {
            ListNode nextNode = curNode.next;

            curNode.next = preNode;

            preNode = curNode;
            curNode = nextNode;
        }

        head.next = null;
        return preNode;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}