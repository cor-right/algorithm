package _2025.subjects._10_graph_bfs_2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 水位上涨的泳池中游泳
 *
 * @author 佳叙
 * @date 2025/4/6
 * @description <a href="https://leetcode.cn/problems/swim-in-rising-water/"/>
 */
public class _778_swim_in_rising_water {

    private static final int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * 耗时取决于最终路径上的最高水位，最优就是路径上的最高水位相对于其他路径最低
     *
     * @param grid
     * @return
     */
    public int swimInWater(int[][] grid) {
        if (grid.length == 1) {
            return 0;
        }

        int minTime = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> grid[a[0]][a[1]]));
        queue.offer(new int[] {0, 0});

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] src = queue.poll();
            int x = src[0];
            int y = src[1];

            if (grid[x][y] > minTime) {
                minTime = grid[x][y];
            }

            if (x == grid.length - 1 && y == grid[0].length - 1) {
                return minTime;
            }

            for (int[] dir : dirs) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];

                if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length || visited[nextX][nextY]) {
                    continue;
                }

                queue.offer(new int[] {nextX, nextY});
                visited[nextX][nextY] = true;
            }
        }

        return minTime;
    }

}