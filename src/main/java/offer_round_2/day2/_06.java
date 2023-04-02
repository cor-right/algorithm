package offer_round_2.day2;

import java.util.Stack;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 *
 */
public class _06 {


    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }

        Stack<Integer> stack = new Stack<>();

        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int[] result = new int[stack.size()];

        int order = 0;
        while (!stack.isEmpty()) {
            result[order++] = stack.pop();
        }

        return result;
    }

}
