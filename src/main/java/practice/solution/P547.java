package practice.solution;

/**
 * @Author William Wang
 */
public class P547 {

    private int[][] grid;
    private int N;

    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }
        N = M.length;
        grid = M;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (M[i][i] == 1) {
                dfs(i);
                ans++;
            }
        }
        return ans;

    }

    private void dfs(int p) {
        if (grid[p][p] == 0) {
            return;
        }
        for (int i = 0; i < N; i++) {
            if (grid[p][i] == 1) {
                grid[p][i] = 0;
                grid[i][p] = 0;
                dfs(i);
                // grid[p][i] = 0;
            }
        }
    }
}
