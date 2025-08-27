package practice.solution.P200;

import org.springframework.stereotype.Component;

/**
 * @Author William Wang
 */
@Component
public class P240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        for (int[] row : matrix) {
            int pos = biSearch(target, row);
            if (pos != -1) {
                return true;
            }
        }
        return false;
    }

    private int biSearch(int target, int[] array) {
        if (array == null) {
            return -1;
        }
        int low = 0;
        int high = array.length - 1;
        while (high >= low) {
            int mid = (high + low) / 2;
            int num = array[mid];
            if (num == target) {
                return mid;
            }
            if (target < num) {
                high--;
            }
            if (target > num) {
                low++;
            }
        }
        return -1;
    }


    /**
     * 从右上角看，就是一个二叉搜索树
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            }
        }
        return false;
    }

}
