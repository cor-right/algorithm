package _2025.subjects._9_graph_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 腐烂的橘子
 *
 * @author 佳叙
 * @date 2025/4/5
 * @description <a href="https://leetcode.cn/problems/rotting-oranges/"/>
 */
public class _994_rotting_oranges {

    /**
     *
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int freshCnt = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();

        // Init.
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    freshCnt++;
                }
                if (grid[i][j] == 2) {
                    visited[i][j] = true;
                    queue.offer(new int[] {i, j});
                }
            }
        }

        if (freshCnt == 0) {
            return 0;
        }

        int round = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];

                if (grid[x][y] == 1) {
                    freshCnt--;
                }
                if (freshCnt == 0) {
                    return round;
                }

                for (int[] dir : dirs) {
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];

                    if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length || visited[nextX][nextY]) {
                        continue;
                    }

                    if (grid[nextX][nextY] == 1) {
                        queue.offer(new int[] {nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }

            round++;
        }

        return -1;
    }

}