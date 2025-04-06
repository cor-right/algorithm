package _2025.subjects._11_graph_dfs;

/**
 * 岛屿数量
 *
 * @author 佳叙
 * @date 2025/4/6
 * @description <a href="https://leetcode.cn/problems/number-of-islands/description/"/>
 */
public class _200_number_of_islands {

    private static final int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * DFS
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    recursion(grid, i, j);
                    ans++;
                }
            }
        }

        return ans;
    }

    private void recursion(char[][] grid, int x, int y) {
        grid[x][y] = '0';

        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length || grid[nextX][nextY] != '1') {
                continue;
            }

            recursion(grid, nextX, nextY);
        }
    }

}