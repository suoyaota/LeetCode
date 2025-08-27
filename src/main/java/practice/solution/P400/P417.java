package practice.solution.P400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author William Wang
 */
public class P417 {

    int[][] visited;//太平洋访问-1，大西洋访问-2
    int m, n;
    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        m = matrix.length;
        n = matrix[0].length;
        visited = new int[m][n];

        //太平洋访问
        for (int i = 0; i < m; i++) {
            dfsPacific(matrix, i, 0, 0);
        }
        for (int i = 0; i < n; i++) {
            dfsPacific(matrix, 0, i, 0);
        }
        //大西洋访问
        for (int i = 0; i < m; i++) {
            dfsAtlantic(matrix, i, n - 1, 0);
        }
        for (int i = 0; i < n; i++) {
            dfsAtlantic(matrix, m - 1, i, 0);
        }
        //List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == -3) {
                    // List<Integer> cell = new ArrayList<Integer>();
                    // cell.add(i);
                    // cell.add(j);
                    // ans.add(cell);
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    private void dfsPacific(int[][] matrix, int row, int col, int preVal) {
        if (row < 0 || col < 0 || row >= m || col >= n || visited[row][col] == -1 || matrix[row][col] < preVal) {
            return;
        }
        visited[row][col] = -1;
        preVal = matrix[row][col];
        for (int[] d : directions) {
            dfsPacific(matrix, row + d[0], col + d[1], preVal);
        }
    }

    private void dfsAtlantic(int[][] matrix, int row, int col, int preVal) {
        if (row < 0 || col < 0 || row >= m || col >= n || visited[row][col] < -1 || matrix[row][col] < preVal) {
            return;
        }
        visited[row][col] -= 2;
        preVal = matrix[row][col];
        for (int[] d : directions) {
            dfsAtlantic(matrix, row + d[0], col + d[1], preVal);
        }
    }
}

