package _2025.subjects._9_graph_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 最短的桥
 *
 * @author 佳叙
 * @date 2025/4/5
 * @description <a href="https://leetcode.cn/problems/shortest-bridge/"/>
 */
public class _934_shorted_bridge {

    /**
     * 从一个岛屿出发，在水域上做广度搜索，找另外一个岛.
     *
     * 如何判断是另外一个岛：把第一个岛的所有数据和第二个岛区分开，直接 visited[i][j] == true，或者 grid[i][j] == -1
     * BFS 起点：第一个岛的所有数据
     *
     * @param grid
     * @return
     */
    public int shortestBridge(int[][] grid) {
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        Queue<int[]> initQueue = new LinkedList<>();
        Queue<int[]> loopQueue = new LinkedList<>();

        // Init queue.
        int[] start = findStart(grid);

        initQueue.offer(start);
        visited[start[0]][start[1]] = true;

        while (!initQueue.isEmpty()) {
            int[] pos = initQueue.poll();
            loopQueue.offer(pos);

            int x = pos[0];
            int y = pos[1];

            for (int i = 0; i < dirs.length; i++) {
                int nextX = x + dirs[i][0];
                int nextY = y + dirs[i][1];

                if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length) {
                    continue;
                }

                if (grid[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    initQueue.offer(new int[] {nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }

        // Traversal.
        int ans = 0;
        while (!loopQueue.isEmpty()) {
            int size = loopQueue.size();

            for (int i = 0; i < size; i++) {
                int[] pos = loopQueue.poll();
                int x = pos[0];
                int y = pos[1];

                for (int j = 0; j < dirs.length; j++) {
                    int nextX = x + dirs[j][0];
                    int nextY = y + dirs[j][1];

                    if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length || visited[nextX][nextY]) {
                        continue;
                    }

                    if (grid[nextX][nextY] == 1) {
                        return ans;
                    }
                    else {
                        loopQueue.offer(new int[] {nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }

            ans++;
        }

        return 0;
    }

    private int[] findStart(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

}