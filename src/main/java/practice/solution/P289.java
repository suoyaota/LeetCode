package practice.solution;

import org.springframework.stereotype.Component;

/**
 * @author William Wang
 * @date 2019/10/25 15:31
 */
@Component
public class P289 {

    /**
     * @Date 2019/10/25 15:32
     * @Author William Wang
     * @Desicription Runtime & Memory Usage:100.00%
     * 因为要同时改变，直观地思路是copy原数组
     * 改进做法是 0->1 格子值记为 -1 ； 1 -> 0 格子值记为2；
     * 两次遍历，第一次换代，第二次更正。
     */
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int ans = board[i][j];
                if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] - 1 >= 0) {
                    ans++;
                }
                if (i - 1 >= 0 && board[i - 1][j] - 1 >= 0) {
                    ans++;
                }
                if (i - 1 >= 0 && j + 1 < n && board[i - 1][j + 1] - 1 >= 0) {
                    ans++;
                }
                if (j - 1 >= 0 && board[i][j - 1] - 1 >= 0) {
                    ans++;
                }
                if (j + 1 < n && board[i][j + 1] - 1 >= 0) {
                    ans++;
                }
                if (i + 1 < m && j - 1 >= 0 && board[i + 1][j - 1] - 1 >= 0) {
                    ans++;
                }
                if (i + 1 < m && board[i + 1][j] - 1 >= 0) {
                    ans++;
                }
                if (i + 1 < m && j + 1 < n && board[i + 1][j + 1] - 1 >= 0) {
                    ans++;
                }
                if (board[i][j] == 0 && ans == 3) {
                    board[i][j] = -1;
                }
                if (board[i][j] == 1) {
                    if (ans == 3 || ans == 4) {
                    } else {
                        board[i][j] = 2;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
                if (board[i][j] == -1) {
                    board[i][j] = 1;
                }
            }
        }
    }
}

