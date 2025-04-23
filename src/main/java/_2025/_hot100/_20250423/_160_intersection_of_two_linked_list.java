package _2025._hot100._20250423;

/**
 * 相交链表
 *
 * @author 佳叙
 * @date 2025/4/23
 * @description <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/description/?envType=study-plan-v2&envId=top-100-liked"/>
 */
public class _160_intersection_of_two_linked_list {

    /**
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        boolean flagA = false;
        boolean flagB = false;

        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while (nodeA != nodeB) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;

            if (nodeA == nodeB) {
                return nodeA;
            }

            if (!flagA && nodeA == null) {
                nodeA = headB;
                flagA = true;
            }
            if (!flagB && nodeB == null) {
                nodeB = headA;
                flagB = true;
            }
        }

        return nodeA;
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