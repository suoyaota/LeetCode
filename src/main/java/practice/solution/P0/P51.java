package practice.solution.P0;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author WilliamWang
 * @Date 2025/8/19-15:40
 */


@Component
public class P51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[][] board = new int[n][n];
        for (int j = 0; j < n; j++) {
            backtracking(0, j, board, ans, new ArrayList<>());
        }
        return ans;
    }

    private void backtracking(int x, int y, int[][] board, List<List<String>> ans, List<String> solves) {
        int scale = board.length;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < scale; j++) {
            sb.append(j == y ? "Q" : ".");
        }
        String tempString = sb.toString();
        // 待回溯
        solves.add(tempString);
        if (x == scale - 1) {
            ans.add(new ArrayList<>(solves));
        }
        // 待回溯
        List<int[]> disabledPos = getDisabledPos(board, x, y);
        List<Integer> nextPosYList = new ArrayList<>();
        for (int j = 0; j < scale; j++) {
            if (x + 1 < scale && board[x + 1][j] == 0) {
                nextPosYList.add(j);
            }
        }
        for (int ny : nextPosYList) {
            backtracking(x + 1, ny, board, ans, solves);
        }
        // 回溯
        for (int[] pos : disabledPos) {
            int i = pos[0];
            int j = pos[1];
            board[i][j] = 0;
        }
        solves.remove(solves.size() - 1);
    }

    /**
     * 获取待回溯 不可用坐标
     * @param board
     * @param x
     * @param y
     * @return
     */
    private List<int[]> getDisabledPos(int[][] board, int x, int y) {
        List<int[]> list = new ArrayList<>();
        for (int i = x; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == x
                        || j == y
                        || (x + y) == (i + j)
                        || j == i + y - x) {
                    if (board[i][j] == 0) {
                        board[i][j] = 1;
                        int[] disabledPos = new int[2];
                        disabledPos[0] = i;
                        disabledPos[1] = j;
                        list.add(disabledPos);
                    }
                }
            }
        }
        return list;
    }
}
