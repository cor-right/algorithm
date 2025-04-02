package _2025.subjects._3_linked_list;

/**
 * 删除链表中的节点
 *
 * @author 佳叙
 * @date 2025/4/3
 * @description <a href="https://leetcode.cn/problems/delete-node-in-a-linked-list/description/"/>
 */
public class _237_delete_no_in_a_linked_list {

    /**
     * Two pointer.
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}