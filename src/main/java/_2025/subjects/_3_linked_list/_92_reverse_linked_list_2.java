package _2025.subjects._3_linked_list;

/**
 * 反转链表 Ⅱ
 *
 * @author 佳叙
 * @date 2025/4/3
 * @description <a href="https://leetcode.cn/problems/reverse-linked-list-ii/description/"/>
 */
public class _92_reverse_linked_list_2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode virtual = new ListNode(0, head);

        ListNode preStart = virtual;
        for (int i = 0; i < left - 1; i++) {
            preStart = preStart.next;
        }

        ListNode pre = null;
        ListNode cur = preStart.next;

        for (int i = 0; i < right - left + 1; i++) {
            ListNode tmp = cur.next;

            cur.next = pre;

            pre = cur;
            cur = tmp;
        }

        // This is so fucking smart.
        preStart.next.next = cur;
        preStart.next = pre;

        return virtual.next;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}