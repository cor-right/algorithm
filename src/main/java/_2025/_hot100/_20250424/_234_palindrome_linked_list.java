package _2025._hot100._20250424;

/**
 * 回文链表
 *
 * @author 佳叙
 * @date 2025/4/25
 * @description <a href=""/>
 */
public class _234_palindrome_linked_list {


    /**
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode before = new ListNode(0, head);

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode pre = slow;
        ListNode cur = slow.next;

        while (cur != null) {
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }

        slow.next.next = null;
        slow.next = null;

        ListNode right = pre;
        ListNode left  = head;

        while (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            left  = left.next;
            right = right.next;
        }

        return true;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}