package practice.solution.P0;

import org.springframework.stereotype.Component;

/**
 * @Author WilliamWang
 * @Date 2025/2/19-9:07
 */

@Component
public class P48 {
    public void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // 水平翻转 i,j ->  m-i-1, j
        for (int i = 0; i < m / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[m - i - 1][j];
                matrix[m - i - 1][j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        // 对角线翻转  j , m-i-1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

}
