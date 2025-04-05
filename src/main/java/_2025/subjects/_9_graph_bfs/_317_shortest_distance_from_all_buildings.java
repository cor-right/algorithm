package _2025.subjects._9_graph_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 离建筑物最近的距离
 *
 * @author 佳叙
 * @date 2025/4/5
 * @description <a href="https://leetcode.cn/problems/shortest-distance-from-all-buildings/"/>
 */
public class _317_shortest_distance_from_all_buildings {

    private static final int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * BFS 从房子到空地
     *
     * @param grid
     * @return
     */
    public int shortestDistance(int[][] grid) {
        int[][] distance = new int[grid.length][grid[0].length];
        int[][] reached  = new int[grid.length][grid[0].length];

        int houseNum = 0;

        // For bad case.
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    houseNum++;
                }
            }
        }

        // BFS.
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, new int[] {i, j}, distance, reached);
                }
            }
        }

        // Calculate min.
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && reached[i][j] == houseNum) {
                    min = Math.min(min, distance[i][j]);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    /**
     * Return false if any house unreachable.
     *
     * @param grid
     * @param start
     * @param distance
     * @return
     */
    private void bfs(int[][] grid, int[] start, int[][] distance, int[][] reached) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[start[0]][start[1]] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);

        int round = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];

                if (grid[x][y] == 0) {
                    reached[x][y]  += 1;
                    distance[x][y] += round;
                }

                for (int[] dir : dirs) {
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];

                    if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length || visited[nextX][nextY]) {
                        continue;
                    }

                    visited[nextX][nextY] = true;
                    if (grid[nextX][nextY] == 0) {
                        queue.offer(new int[] {nextX, nextY});
                    }
                }
            }

            round++;
        }
    }
}