package practice.solution.P100;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author WilliamWang
 * @Date 2025/8/16-21:56
 */

@Component
public class P131 {
    List<List<String>> ans;
    boolean[][] dp;

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        dp = getDp(s);
        backtracking(s, 0, new ArrayList<>());
        return ans;
    }

    private void backtracking(String s, int idx, List<String> tempList) {
        if (idx == s.length()) {
            ans.add(new ArrayList<>(tempList));
        }
        for (int i = idx; i < s.length(); i++) {
            if (dp[idx][i]) {
                tempList.add(s.substring(idx, i + 1));
                backtracking(s, i + 1, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private boolean[][] getDp(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                int x = j;
                int y = j + i;
                if (x == y) {
                    dp[x][y] = true;
                    continue;
                }
                if (s.charAt(x) != s.charAt(y)) {
                    dp[x][y] = false;
                    continue;
                }
                if (y - x <= 1 || dp[x + 1][y - 1]) {
                    dp[x][y] = true;
                    continue;
                }
                dp[x][y] = false;
            }
        }
        return dp;
    }
}
