package _2025._hot100._20250324;

import java.util.Optional;

/**
 * 环形链表
 *
 * @author 佳叙
 * @date 2025/3/24
 * @description <a href="https://leetcode.cn/problems/linked-list-cycle/description/"/>
 */
public class _141_linked_list_cycle {

    /**
     * Math.
     *
     * Two pointer. Fast and slow.
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && slow != null) {
            if (fast == slow) {
                return true;
            }

            fast = Optional.ofNullable(fast.next).map(f -> f.next).orElse(null);
            slow = slow.next;
        }

        return false;
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