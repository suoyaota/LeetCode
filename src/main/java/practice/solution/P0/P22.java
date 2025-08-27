package practice.solution.P0;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author WilliamWang
 * @Date 2025/8/15-14:13
 */

@Component
public class P22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder tempString = new StringBuilder();
        backtracking(ans, tempString, 0, n, 0, 0);
        return ans;
    }

    private void backtracking(List<String> ans, StringBuilder tempString, int idx, int targetNum, int leftNum,int rightNum) {
        if (idx == targetNum * 2) {
            ans.add(new String(tempString));
            return;
        }
        if (leftNum < targetNum) {
            tempString.append("(");
            backtracking(ans, tempString, idx + 1, targetNum, leftNum + 1, rightNum);
            tempString.deleteCharAt(tempString.length() - 1);
        }
        if (rightNum < leftNum) {
            tempString.append(")");
            backtracking(ans, tempString, idx + 1, targetNum, leftNum, rightNum + 1);
            tempString.deleteCharAt(tempString.length() - 1);
        }
    }
}
