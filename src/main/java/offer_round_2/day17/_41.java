package offer_round_2.day17;

import java.nio.channels.Pipe;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 41. 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例 1：
 *
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * 示例 2：
 *
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 *
 *
 * 限制：
 *
 * 最多会对 addNum、findMedian 进行 50000 次调用。
 * 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-stream/
 *
 * 通过次数132,221提交次数226,676
 */
public class _41 {

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */

    class MedianFinder {

        // 小根堆保存较大的那一半，堆顶就是中位数
        private final PriorityQueue<Integer> smlHeap = new PriorityQueue<>();

        // 大根堆保存较小的那一半，根顶就是中位数
        private final PriorityQueue<Integer> bigHeap = new PriorityQueue<>((a, b) -> b - a);

        /** initialize your data structure here. */
        public MedianFinder() {

        }

        // 从数据流中添加一个整数到数据结构中。
        public void addNum(int num) {
            // 先进小根堆，拿到最小的
            smlHeap.offer(num);
            bigHeap.offer(smlHeap.poll());

            // 然后把小根堆的最小的放到大根堆里，拿到大根堆里最大的，再放回小根堆，此时可以保持小根堆的任意数都比大根堆大
            if (smlHeap.size() != bigHeap.size()) {
                smlHeap.offer(bigHeap.poll());
            }
        }

        //  返回目前所有元素的中位数。
        public double findMedian() {
            if (smlHeap.peek() == null) {
                return 0;
            }
            return smlHeap.size() == bigHeap.size() ? (smlHeap.peek() + bigHeap.peek()) / 2.0 : smlHeap.peek();
        }
    }

}
