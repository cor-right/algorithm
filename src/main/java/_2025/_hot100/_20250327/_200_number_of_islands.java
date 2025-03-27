package _2025._hot100._20250327;

/**
 * 岛屿数量
 *
 * @author 佳叙
 * @date 2025/3/27
 * @description <a href="https://leetcode.cn/problems/number-of-islands/description/"/>
 */
public class _200_number_of_islands {

    /**
     * - 先污染后治理：先递归进入，后跳出
     * - 原数组上直接操作：减少内存占用
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int num = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    visit(grid, i, j);
                }
            }
        }

        return num;
    }

    private void visit(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return ;
        }

        grid[i][j] = '2';

        visit(grid, i - 1, j);
        visit(grid, i + 1, j);
        visit(grid, i, j - 1);
        visit(grid, i, j + 1);
    }

}