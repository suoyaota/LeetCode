package practice.solution;

import org.springframework.stereotype.Component;

/**
 * @author wyb
 */
@Component
public class P130 {

    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int m, n;
    private char[][] grid;

    public void solve(char[][] board) {
        if (board == null || board.length < 3 || board[0].length < 3) {
            return;
        }

        m = board.length;
        n = board[0].length;
        grid = board;

        //dfs上下边
        for (int i = 0; i < n; i++) {
            dfs(0, i);
            dfs(m - 1, i);
        }
        //dfs左右边
        for (int j = 1; j < m - 1; j++) {
            dfs(j, 0);
            dfs(j, n - 1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int row, int col) {
        if (row < 0 || col < 0 || row >= m || col >= n || grid[row][col] == 'X' || grid[row][col] == 'T') {
            return;
        }
        grid[row][col] = 'T';
        for (int[] d : directions) {
            dfs(row + d[0], col + d[1]);
        }
    }
}

