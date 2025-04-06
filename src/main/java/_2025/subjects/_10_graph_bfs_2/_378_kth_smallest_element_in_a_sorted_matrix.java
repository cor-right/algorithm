package _2025.subjects._10_graph_bfs_2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 有序矩阵中第 K 小的元素
 *
 * @author 佳叙
 * @date 2025/4/6
 * @description <a href="https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/description/"/>
 */
public class _378_kth_smallest_element_in_a_sorted_matrix {

    /**
     * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
     * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素 （这代表不需要过滤重复元素）
     *
     * [1,   5,  9]
     * [10, 11, 13]
     * [12, 13, 15]
     *
     * 1. 可以用二分查找，上下边界分别是 matrix[0][0] 和 matrix[n - 1][n - 1]，比较函数就是看不高于 mid 的元素数量
     * 2. 可以用最小堆，从左上到右下，始终维护当前可能最小的元素，并循环 k 次
     *
     * 这里用的是最小堆
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(arr -> matrix[arr[0]][arr[1]]));
        queue.offer(new int[] {0, 0});

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        visited[0][0] = true;

        for (int i = 0; i < k - 1; i++) {
            int[] src = queue.poll();
            int x = src[0];
            int y = src[1];

            for (int[] dir : dirs) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];

                if (nextX < 0 || nextY < 0 || nextX >= matrix.length || nextY >= matrix[0].length || visited[nextX][nextY]) {
                    continue;
                }

                queue.offer(new int[] {nextX, nextY});
                visited[nextX][nextY] = true;
            }
        }

        return matrix[queue.peek()[0]][queue.peek()[1]];
    }

}