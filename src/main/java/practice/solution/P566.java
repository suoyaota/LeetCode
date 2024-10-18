package practice.solution;


/**
 * @Author William Wang
 */
public class P566 {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (r * c != nums.length * nums[0].length) {
            return nums;
        }
        int[][] ans = new int[r][c];
        int n = 0;
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (n < c) {
                    ans[m][n] = nums[i][j];
                } else {
                    n = 0;
                    m++;
                    ans[m][n] = nums[i][j];
                }
                n++;
            }
        }
        return ans;
    }


    public int[][] matrixReshape2(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        int idx = 0;//用于遍历二维数组，[idx/n][idx%n]
        if (r * c != m * n) {
            return nums;
        }
        int[][] ans = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[i][j] = nums[idx / n][idx % n];
                idx++;
            }
        }
        return ans;
    }
}

