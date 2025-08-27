package practice.solution.P0;

import org.springframework.stereotype.Component;

/**
 * @Author WilliamWang
 * @Date 2025/8/15-16:41
 */

@Component
public class P79 {
    int[][] dr = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    boolean ans;
    public boolean exist(char[][] board, String word) {
        if (board == null || board[0].length == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backtracking(i, j, 0, word, board, used);
                if (ans) {
                    return true;
                }
            }
        }
        return false;
    }
    private void backtracking(int x, int y, int idx, String word, char[][] board, boolean[][] used) {
        if (board[x][y] != word.charAt(idx)) {
            return;
        }
        if (idx == word.length() - 1) {
            ans = true;
            return;
        }
        used[x][y] = true;
        for (int[] d: dr) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (!ans && nx >=0 && nx < board.length && ny >=0 && ny < board[0].length && !used[nx][ny]) {
                backtracking(nx, ny, idx + 1, word, board, used);
            }
        }
        used[x][y] = false;
    }
}
