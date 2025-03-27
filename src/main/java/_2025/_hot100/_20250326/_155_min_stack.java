package _2025._hot100._20250326;

import java.util.Stack;

/**
 * @author 佳叙
 * @date 2025/3/27
 * @description <a href="https://leetcode.cn/problems/min-stack/description/"/>
 */
public class _155_min_stack {

    private Stack<Integer> data;
    private Stack<Integer> minData;

    /**
     * 辅助栈
     */
    public _155_min_stack() {
        data = new Stack<>();
        minData = new Stack<>();
    }

    public void push(int val) {
        data.push(val);
        minData.push(minData.isEmpty() ? val : Math.min(minData.peek(), val));
    }

    public void pop() {
        data.pop();
        minData.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minData.peek();
    }

}