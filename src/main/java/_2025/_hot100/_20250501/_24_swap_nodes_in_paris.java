package _2025._hot100._20250501;

/**
 * 两两交换链表中的节点
 *
 * @author 佳叙
 * @date 2025/5/1
 * @description <a href=""/>
 */
public class _24_swap_nodes_in_paris {


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode ans = new ListNode(0, head);
        ListNode pre = ans;

        while (pre.next != null && pre.next.next != null) {
            ListNode a = pre.next;
            ListNode b = pre.next.next;

            a.next = b.next;
            b.next = a;
            pre.next = b;

            pre = pre.next.next;
        }

        return ans.next;
    }


     private class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

}