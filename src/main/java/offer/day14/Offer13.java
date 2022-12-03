package offer.day14;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

/**
 * @code https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=108mt86
 *
 * 面试题13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 */
public class Offer13 {

    /**
     * BFS
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        Queue<Index> queue = new LinkedList<Index>() {{add(new Index(0, 0));}};
        int count = 0;

        boolean[][] visited = new boolean[m][n];
        while (!queue.isEmpty()) {
            Index poll = queue.poll();

            if (visited[poll.x][poll.y]) {
                continue;
            }

            count++;
            visited[poll.x][poll.y] = true;

            if (poll.x + 1 <= m - 1 && countDigitSum(poll.x + 1, poll.y) <= k) {
                queue.add(new Index(poll.x + 1, poll.y));
            }
            if (poll.y + 1 <= n - 1 && countDigitSum(poll.x, poll.y + 1) <= k) {
                queue.add(new Index(poll.x, poll.y + 1));
            }
        }

        return count;

    }

    private int countDigitSum(int m, int n) {
        int res = 0;
        while (m != 0) {
            res += m % 10;
            m /= 10;
        }
        while (n != 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }

    class Index {
        public int x;
        public int y;
        Index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
