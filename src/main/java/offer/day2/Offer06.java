package offer.day2;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2,4]
 * 输出：[4,2,3,1]
 *
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 *
 * 指针方向的调换
 *
 * HEAD -> 1 -> 3 -> 2 -> 4 -> NULL
 * NULL <- 1 <- 3 <- 2 <- 4 <- HEAD
 *
 * 最后要返回4
 *
 * 递归的深度是个问题，所以选择堆栈来模拟
 */
public class Offer06 {

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public int[] reversePrint(ListNode head) {

        if (head == null) {
            return new int[]{};
        }

        if (head.next == null) {
            return new int[] {head.val};
        }

        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        int[] result = new int[stack.size()];
        int index = 0;
        while (!stack.empty()) {
            result[index++] = stack.pop().val;
        }

        return result;
    }



}
