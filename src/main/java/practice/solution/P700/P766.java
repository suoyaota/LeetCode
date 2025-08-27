package practice.solution.P700;


/**
 * @Author William Wang
 */
public class P766 {

    //非递归写法  72.53     29.00
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 1 || n == 1) {
            return true;
        }
        for (int i = m - 1; i >= 0; i--) {
            int x = 0;
            int y = i;
            while (y + 1 < m && x + 1 < n) {
                if (matrix[y + 1][x + 1] != matrix[y][x]) {
                    return false;
                }
                y++;
                x++;
            }
        }
        for (int i = 1; i < n; i++) {
            int x = i;
            int y = 0;
            while (y + 1 < m && x + 1 < n) {
                if (matrix[y + 1][x + 1] != matrix[y][x]) {
                    return false;
                }
                y++;
                x++;
            }
        }
        return true;
    }

    //递归写法   72.35   11.94
    public boolean isToeplitzMatrix2(int[][] matrix) {
        for (int i = matrix.length - 1; i >= 0; i--) {
            if (!check(matrix[i][0], matrix, 0, i)) {
                return false;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (!check(matrix[0][i], matrix, i, 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean check(int val, int[][] matrix, int x, int y) {
        if (x == matrix[0].length || y == matrix.length) {
            return true;
        }
        if (matrix[y][x] != val) {
            return false;
        }
        return check(val, matrix, x + 1, y + 1);
    }
}

