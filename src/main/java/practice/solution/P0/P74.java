package practice.solution.P0;

import org.springframework.stereotype.Component;

/**
 * @Author WilliamWang
 * @Date 2025/9/12-15:22
 */

@Component
public class P74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m * n - 1;
        while (r >= l) {
            int mid = (r + l) / 2;
            int i = mid / n;
            int j = mid - i * n;
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                l = mid + 1;
            } else if (matrix[i][j] > target) {
                r = mid - 1;
            }
        }
        return false;
    }
}
