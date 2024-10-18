package practice.solution;

import org.springframework.stereotype.Component;

/**
 * @Author William Wang
 */
@Component
public class P240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        //排除法，矩阵右下角的数是这个矩阵最大的数，如果大于目标，则该矩阵里没有这个目标
        int m = matrix.length;
        int n = matrix[0].length;
        if (matrix == null || m <= 0 || n <= 0) {
            return false;
        }
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
