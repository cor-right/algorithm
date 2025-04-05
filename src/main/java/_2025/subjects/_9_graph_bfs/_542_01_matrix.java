package _2025.subjects._9_graph_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 *     Graph Representation.
 *     1. Adjacency Matrix: 节点数量已知时可用
 *     2. Adjacency List: 空间占用更少，可以处理节点数量未知的情况
 *
 *     Adjacency Matrix Definition.
 *     1. List<T>[n]
 *     2. Map<T, List<T>>
 * </p>
 *
 * <p>
 *     BFS：以层为概念的搜索方式，适合寻找最短路径
 *     1. 因为是水平展开所有nodes，图可能有环，所以需要查重
 *     2. 只适用于 Uniform Cost，即每条 edge 的 weight 都一样的场景
 * </p>
 *
 * @author 佳叙
 * @date 2025/4/5
 * @description <a href="https://leetcode.cn/problems/01-matrix/description/"/>
 */
public class _542_01_matrix {


    /**
     * 正向思维：从 1 出发，BFS 寻找最近的 0，时间复杂度高，可能达到 O (mn * mn)
     * 逆向思维：从 0 出发，BFS 寻找周围的 1，时间复杂度低，O (mn)
     *
     * @param mat
     * @return
     */
    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        int[][]     ans = new int[mat.length][mat[0].length];
        boolean[][] vst = new boolean[mat.length][mat[0].length];

        // Init start points.
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    vst[i][j] = true;
                    queue.offer(new int[] {i, j});
                }
            }
        }

        // Search.
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                // Poll out current element.
                int[] ele = queue.poll();
                int x = ele[0];
                int y = ele[1];

                // Search nearby.
                for (int[] dir : dirs) {
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];

                    if (nextX >= 0 && nextY >= 0 && nextX < mat.length && nextY < mat[0].length && !vst[nextX][nextY]) {
                        ans[nextX][nextY] = ans[x][y] + 1;
                        vst[nextX][nextY] = true;

                        queue.offer(new int[] {nextX, nextY});
                    }
                }
            }
        }

        return ans;
    }

}