package offer.day1;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *  
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *  
 *
 * 提示：
 *
 * 各函数的调用总次数不超过 20000 次
 *  
 *
 * 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/
 *
 * 通过次数295,979提交次数532,493
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 辅助栈！！！！！！！
 */
public class MinStack {

    private Stack<Integer> mainStack = new Stack<>();

    private Stack<Integer> minStack = new Stack<>();
    {
        minStack.add(Integer.MAX_VALUE);
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.min();
     */

    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        mainStack.add(x);
        if (x < minStack.peek()) {
            minStack.add(x);
        } else {
            minStack.add(minStack.peek());
        }
    }

    public void pop() {
        mainStack.pop();
        minStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}


