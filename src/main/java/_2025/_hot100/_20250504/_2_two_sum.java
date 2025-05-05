package _2025._hot100._20250504;

/**
 * @author 佳叙
 * @date 2025/5/4
 * @description <a href=""/>
 */
public class _2_two_sum {

    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode node = ans;

        int prefix = 0;
        while (l1 != null || l2 != null) {
            int sum = prefix;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            node.next = new ListNode(sum % 10);
            node = node.next;

            prefix = sum / 10;
        }

        if (prefix != 0) {
            node.next = new ListNode(prefix);
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