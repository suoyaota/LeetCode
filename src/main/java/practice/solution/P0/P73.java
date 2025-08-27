package practice.solution.P0;

import org.springframework.stereotype.Component;

/**
 * @Author WilliamWang
 * @Date 2025/2/18-15:57
 */

@Component
public class P73 {

    public void setZeroes(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean hasZeroInRow1 = false;
        boolean hasZeroInCol1 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                hasZeroInCol1 = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                hasZeroInRow1 = true;
                break;
            }
        }
        // 用第一行、第一列记录该行该列有无0
        // 因为这里会给第一行第一列写入0，破坏第一行第一列有无0的判断，所以需要hasZeroInRow1、hasZeroInCol1提前记录
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        // 处理除第一行、第一列外的值，若该行、列有0，则置为0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 处理第一行、列
        if (hasZeroInRow1) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (hasZeroInCol1) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
