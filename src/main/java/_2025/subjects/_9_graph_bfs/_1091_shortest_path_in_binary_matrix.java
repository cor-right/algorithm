package _2025.subjects._9_graph_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二进制矩阵中的最短路径
 *
 * @author 佳叙
 * @date 2025/4/5
 * @description <a href="https://leetcode.cn/problems/shortest-path-in-binary-matrix/"/>
 */
public class _1091_shortest_path_in_binary_matrix {

    /**
     *
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }

        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});

        int len = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];

                if (x == grid.length - 1 && y == grid[0].length - 1) {
                    return len;
                }

                for (int[] dir : dirs) {
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];

                    if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length || visited[nextX][nextY]) {
                        continue;
                    }

                    if (grid[nextX][nextY] == 0) {
                        visited[nextX][nextY] = true;
                        queue.offer(new int[] {nextX, nextY});
                    }
                }
            }

            len++;
        }

        return -1;
    }

}