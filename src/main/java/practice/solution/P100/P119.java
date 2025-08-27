package practice.solution.P100;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2019/10/9 18:23
 * @Author William Wang
 */
@Component
public class P119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<Integer>();
        if (rowIndex == 0) {
            ans.add(1);
            return ans;
        }
        List<Integer> preRow = new ArrayList<Integer>();
        for (int i = 1; i < rowIndex + 1; i++) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(preRow.get(j - 1) + preRow.get(j));
            }
            row.add(1);
            preRow = row;
        }
        return preRow;
    }
}


