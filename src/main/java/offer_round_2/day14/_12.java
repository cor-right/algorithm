package offer_round_2.day14;

/**
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
 *
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
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 *
 * 通过次数328,286提交次数718,313
 */
public class _12 {

    public boolean exist(char[][] board, String word) {
        boolean[][] visitedMap = new boolean[board.length][board[0].length];

        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, visitedMap, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, boolean[][] visitedMap, char[] words, int row, int col, int charIdx) {
        if (board[row][col] != words[charIdx]) {
            return false;
        }

        if (charIdx >= words.length - 1) {
            return true;
        }

        visitedMap[row][col] = true;

        // search
        boolean result = false;
        if (row > 0 && !visitedMap[row - 1][col]) {
            result |= search(board, visitedMap, words, row - 1, col, charIdx + 1);
        }
        if (row + 1 < board.length && !visitedMap[row + 1][col]) {
            result |= search(board, visitedMap, words, row + 1, col, charIdx + 1);
        }
        if (col > 0 && !visitedMap[row][col - 1]) {
            result |= search(board, visitedMap, words, row, col - 1, charIdx + 1);
        }
        if (col + 1 < board[0].length && !visitedMap[row][col + 1]) {
            result |= search(board, visitedMap, words, row, col + 1, charIdx + 1);
        }

        visitedMap[row][col] = false;
        return result;
    }





}
