package _2025._hot100._20250324;

import java.util.Optional;

/**
 * @author 佳叙
 * @date 2025/3/24
 * @description <a href="https://leetcode.cn/problemset/?listId=2cktkvj&page=2"/>
 */
public class _142_linked_list_cycle_2 {

    /**
     * Math.
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = Optional.ofNullable(head.next).map(f -> f.next).orElse(null);
        ListNode slow = head.next;

        while (fast != null && slow != null) {
            fast = Optional.ofNullable(fast.next).map(f -> f.next).orElse(null);
            slow = slow.next;

            if (fast == slow) {
                break;
            }
        }

        if (fast == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
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