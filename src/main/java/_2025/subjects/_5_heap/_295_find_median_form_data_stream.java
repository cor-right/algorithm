package _2025.subjects._5_heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流的中位数
 *
 * @author 佳叙
 * @date 2025/4/4
 * @description <a href="https://leetcode.cn/problems/find-median-from-data-stream/description/"/>
 */
public class _295_find_median_form_data_stream {

    PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> right  = new PriorityQueue<>();

    private int size;

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
    public _295_find_median_form_data_stream() {
    }

    public void addNum(int num) {
        left.offer(num);
        size++;

        if (left.size() > right.size()) {
            right.offer(left.poll());
        }

        if (!left.isEmpty() && !right.isEmpty() && right.peek() < left.peek()) {
            right.offer(left.poll());
            left.offer(right.poll());
        }
    }

    public double findMedian() {
        return size % 2 == 1 ? right.peek() : (left.peek() + right.peek()) / 2.0;
    }
}