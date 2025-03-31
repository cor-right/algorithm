package _2025._hot100._20250330;

/**
 * 回文链表
 *
 * @author 佳叙
 * @date 2025/3/30
 * @description <a href="https://leetcode.cn/problems/palindrome-linked-list/description/"/>
 */
public class _234_palindrome_linked_list {

    public boolean isPalindrome(ListNode head) {
        return isPalindromeWithPointer(head);
    }

    /**
     * SLOW 需要节点指向中间节点或中间节点的前一个节点，因此快指针的 WHILE 条件要做一些文章.
     *
     * 1 - 0
     * 2 - 0
     * 3 - 1
     * 4 - 1
     * 5 - 2
     * 6 - 2
     * 7 - 3
     * 8 - 3
     *
     * @param head
     * @return
     */
    private boolean isPalindromeWithPointer(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode forward  = head;
        ListNode backward = reverseList(slow);

        slow.next = null;

        while (forward != null && backward != null) {
            if (forward.val != backward.val) {
                return false;
            }

            forward  = forward.next;
            backward = backward.next;
        }

        return true;
    }

    /**
     * 反转链表
     *
     * @param node
     * @return
     */
    private ListNode reverseList(ListNode node) {
        ListNode pre = null;
        ListNode cur = node.next;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }

        return pre;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}