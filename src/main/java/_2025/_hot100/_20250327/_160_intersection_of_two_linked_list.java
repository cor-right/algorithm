package _2025._hot100._20250327;

/**
 * 相交链表
 *
 * @author 佳叙
 * @date 2025/3/27
 * @description <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/description/"/>
 */
public class _160_intersection_of_two_linked_list {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != null || b != null) {
            if (a == b) {
                return a;
            }

            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return null;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}