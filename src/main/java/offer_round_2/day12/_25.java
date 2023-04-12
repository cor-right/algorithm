package offer_round_2.day12;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 *
 * 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * 通过次数344,248提交次数475,527
 */
public class _25 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head;
        if (l1.val <= l2.val) {
            head = l1;
            merge(head, l1.next, l2);
        }
        else {
            head = l2;
            merge(head, l1, l2.next);
        }

        return head;
    }

    private void merge(ListNode result, ListNode la, ListNode lb) {
        if (la == null) {
            result.next = lb;
            return ;
        }
        if (lb == null) {
            result.next = la;
            return ;
        }

        if (la.val <= lb.val) {
            result.next = la;
            merge(result.next, la.next, lb);
        }
        else {
            result.next = lb;
            merge(result.next, la, lb.next);
        }
    }

}
