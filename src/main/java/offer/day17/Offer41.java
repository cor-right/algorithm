package offer.day17;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @code https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=108mt86
 *
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
 */
public class Offer41 {

    /**
     * 中位数
     *
     * data[(len - 1) / 2]
     * (data[(len - 1) / 2] + data[(len - 1) / 2 + 1]) / 2
     *
     * 因为堆只能满足 len/2 或 len/2 - 1 个元素有序，所以需要两个堆
     *
     * 大顶堆，可以使较大的那部分有序，所以存放较小的那部分数，这样其中最大的就是中位数，大顶堆设为 smallPartHeap
     * 小顶堆，可以使较小的那部分有序，所以存放较大的那部分数，这样其中最小的就是中位数，小顶堆设为 largePartHeap
     *
     * 新元素进入，把 smallPartHeap 的堆顶元素放到 largePartHeap 中，并将新元素放到 smallPartHeap 中，同时进行两个堆的调整
     *
     * 在两堆元素数量相同的时候， smallPartHeap 截留堆顶元素，同时收纳新元素，数量会比 largePartHeap 多一个，此时 smallPartHeap 堆顶就是中位数
     *
     */
    class MedianFinder {

        private PriorityQueue<Integer> smallPartHeap = new PriorityQueue<>((a, b) -> b - a);
        private PriorityQueue<Integer> largePartHeap = new PriorityQueue<>();


        /** initialize your data structure here. */
        public MedianFinder() {

        }

        public void addNum(int num) {
            if (smallPartHeap.size() == largePartHeap.size()) {
                largePartHeap.offer(num);
                smallPartHeap.offer(largePartHeap.poll());
            }
            else {
                smallPartHeap.offer(num);
                largePartHeap.offer(smallPartHeap.poll());
            }
        }

        public double findMedian() {
            if (largePartHeap.size() == 0) {
                return smallPartHeap.size() == 0 ? 0 : smallPartHeap.poll();
            }
            return smallPartHeap.size() == largePartHeap.size() ? (smallPartHeap.poll() + largePartHeap.poll()) / 2.0 : smallPartHeap.poll();
        }


    }

}
