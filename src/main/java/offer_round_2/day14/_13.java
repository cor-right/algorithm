package offer_round_2.day14;

import java.util.LinkedList;
import java.util.Queue;

public class _13 {

    // bfs
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }

        boolean[][] visitMap = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        visitMap[0][0] = true;

        int total = 0;
        while (!queue.isEmpty()) {
            int[] index = queue.poll();

            int row = index[0];
            int col = index[1];

            if (visitMap[row][col]) {
                continue;
            }

            visitMap[row][col] = true;
            total++;

            if (row >= 1 && !visitMap[row - 1][col] && computeNumber(row - 1, col) <= k) {
                queue.offer(new int[] {row - 1, col});
            }
            if (row < m - 1 && !visitMap[row + 1][col] && computeNumber(row + 1, col) <= k) {
                queue.offer(new int[] {row + 1, col});
            }
            if (col >= 1 && !visitMap[row][col - 1] && computeNumber(row, col - 1) <= k) {
                queue.offer(new int[] {row, col - 1});
            }
            if (col < n - 1 && !visitMap[row][col + 1] && computeNumber(row, col + 1) <= k) {
                queue.offer(new int[] {row, col + 1});
            }
        }

        return total;
    }

    private int computeNumber(int m, int n) {
        int sum = 0;
        while (m != 0) {
            sum += m % 10;
            m = m / 10;
        }
        while (n != 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }

}
