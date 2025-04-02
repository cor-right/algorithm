package _2025.subjects._3_linked_list;

/**
 * K 个一组反转链表（HARD）
 *
 * @author 佳叙
 * @date 2025/4/3
 * @description <a href="https://leetcode.cn/problems/reverse-nodes-in-k-group/description/"/>
 */
public class _25_reverse_nodes_in_k_group {

    /**
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        ListNode virtualHead = new ListNode(0, head);

        ListNode pre = virtualHead;
        ListNode cur = pre.next;

        int cnt = 1;
        while (cur != null) {
            if (cnt == k) {
                ListNode tmp = cur.next;

                reverse(pre.next, cur);

                // Link the reversed part tail to the right list
                pre.next.next = tmp;

                // Link the reversed part head to the left list
                ListNode newPre = pre.next;
                pre.next = cur;

                // Reset pre and cur
                pre = newPre;
                cur = tmp;

                // Recount
                cnt = 1;
            }
            else {
                cur = cur.next;
                cnt++;
            }
        }

        return virtualHead.next;
    }

    /**
     * 反转部分链表
     *
     * @param head
     * @param tail
     */
    private void reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode cur = head;

        while (pre != tail) {
            ListNode tmp = cur.next;

            cur.next = pre;

            pre = cur;
            cur = tmp;
        }
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}