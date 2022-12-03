package offer.day14;


/**
 * @code https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=108mt86
 *
 * 剑指 Offer 12. 矩阵中的路径
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *
 *
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 *
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *
 *
 * 提示：
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 */
public class Offer12 {

    /**
     * DFS
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (hit(board, visited, row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hit(char[][] board, boolean[][] visited, int row, int col, String word, int charIdx) {
        if (!canVisited(board, visited, row, col)) {
            return false;
        }
        if (board[row][col] != word.charAt(charIdx)) {
            return false;
        }
        if (word.length() - 1 == charIdx) {
            return true;
        }

        visited[row][col] = true;
        boolean ifHit =
                hit(board, visited, row + 1, col, word, charIdx + 1) ||
                hit(board, visited, row - 1, col, word, charIdx + 1) ||
                hit(board, visited, row, col + 1, word, charIdx + 1) ||
                hit(board, visited, row, col - 1, word, charIdx + 1);
        visited[row][col] = false;
        return ifHit;
    }

    private boolean canVisited(char[][] board, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= board.length) {
            return false;
        }
        if (col < 0 || col >= board[0].length) {
            return false;
        }
        if (visited[row][col]) {
            return false;
        }
        return true;
    }


}
