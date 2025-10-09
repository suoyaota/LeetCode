package practice.solution.P1000;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author William Wang
 */
public class P1091 {

    private static final int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}};
    private int row;
    private int col;

    public int shortestPathBinaryMatrix(int[][] grid) {
        //检查非法输入
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        row = grid.length;
        col = grid[0].length;
        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
            return -1;
        }
        //定义队列,添加起点
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int ans = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            while (size-- > 0) {
                int[] cur = queue.poll();
                int cr = cur[0];
                int cc = cur[1];
                //检查题目条件
                if (cr == row - 1 && cc == col - 1) {
                    return ans;
                }
                grid[cr][cc] = 1;

                //放入下一轮结点
                for (int[] d : directions) {
                    int nr = cr + d[0];
                    int nc = cc + d[1];
                    if (inGrid(nr, nc) && grid[nr][nc] == 0) {
                        queue.offer(new int[]{nr, nc});
                        grid[nr][nc] = 1;
                    }
                }
            }
        }
        return -1;
    }

    private boolean inGrid(int r, int c) {
        return r >= 0 && c >= 0 && r < row && c < col;
    }
}

