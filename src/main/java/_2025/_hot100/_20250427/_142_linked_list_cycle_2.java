package _2025._hot100._20250427;

import java.util.Optional;

/**
 * 环形链表 Ⅱ
 *
 * @author 佳叙
 * @date 2025/4/27
 * @description <a href=""/>
 */
public class _142_linked_list_cycle_2 {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        // Determine loop
        while (fast != null && fast != slow) {
            fast = Optional.ofNullable(fast.next).map(node -> node.next).orElse(null);
            slow = slow.next;
        }

        if (fast == null) {
            return null;
        }

        // Find entrance
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}