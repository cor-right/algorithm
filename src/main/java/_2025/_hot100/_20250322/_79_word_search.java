package _2025._hot100._20250322;

/**
 * @author jiaxu.zjx
 * @date 2025/3/22 21:56
 * @description <a href="https://leetcode.cn/problems/word-search/description/"/>
 */
public class _79_word_search {

    /**
     * Recursion.
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && search(visited, board, i, j, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(boolean[][] visited, char[][] board, int x, int y, int index, String word) {
        if (index == word.length() - 1) {
            return true;
        }

        visited[x][y] = true;
        char nextCh = word.charAt(index + 1);

        boolean find = false;
        if (x > 0 && !visited[x - 1][y] && board[x - 1][y] == nextCh) {
            find |= search(visited, board, x - 1, y, index + 1, word);
        }
        if (!find && y > 0 && !visited[x][y - 1] && board[x][y - 1] == nextCh) {
            find |= search(visited, board, x, y - 1, index + 1, word);
        }
        if (!find && x < board.length - 1 && !visited[x + 1][y] && board[x + 1][y] == nextCh) {
            find |= search(visited, board, x + 1, y, index + 1, word);
        }
        if (!find && y < board[0].length - 1 && !visited[x][y + 1] && board[x][y + 1] == nextCh) {
            find |= search(visited, board, x, y + 1, index + 1, word);
        }

        visited[x][y] = false;
        return find;
    }

}
