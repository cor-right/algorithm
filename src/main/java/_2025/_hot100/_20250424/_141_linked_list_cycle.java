package _2025._hot100._20250424;

/**
 * 环形链表
 *
 * @author 佳叙
 * @date 2025/4/25
 * @description <a href=""/>
 */
public class _141_linked_list_cycle {

    /**
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && slow != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next == null ? null : fast.next.next;
            slow = slow.next;
        }

        return true;
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