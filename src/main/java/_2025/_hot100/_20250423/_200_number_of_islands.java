package _2025._hot100._20250423;

/**
 * 岛屿数量
 *
 * @author 佳叙
 * @date 2025/4/23
 * @description <a href="https://leetcode.cn/problems/number-of-islands/?envType=study-plan-v2&envId=top-100-liked"/>
 */
public class _200_number_of_islands {



    /**
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        byte[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '0') {
                    num++;
                    traversal(grid, dirs, i, j);
                }
            }
        }

        return num;
    }

    private void traversal(char[][] grid, byte[][] dirs, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return ;
        }

        grid[i][j] = '0';
        for (byte[] dir : dirs) {
            traversal(grid, dirs, i + dir[0], i + dir[1]);
        }
    }

}