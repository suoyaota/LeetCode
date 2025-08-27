package practice.solution.P100;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2019/10/9 18:23
 * @Author William Wang
 */
@Component
public class P118 {

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            return ans;
        }
        int[][] num = new int[numRows][];
        num[0] = new int[numRows];
        for (int i = 0; i < numRows; i++) {
            num[0][i] = 1;
        }
        for (int i = 1; i < numRows; i++) {
            num[i] = new int[numRows - i];
            for (int j = 0; j < numRows - i; j++) {
                if (j == 0) {
                    num[i][j] = 1;
                } else {
                    num[i][j] = num[i][j - 1] + num[i - 1][j];
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            int n = 0;
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < i + 1; j++) {
                int m = i - n;
                row.add(num[m][n]);
                n++;
            }
            ans.add(row);
        }
        return ans;
    }
}


