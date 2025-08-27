package practice.solution.P0;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author WilliamWang
 * @Date 2025/8/15-13:46
 */

@Component
public class P39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtrack(ans, tempList, 0, candidates, target, 0);
        return ans;
    }
    private void backtrack(List<List<Integer>> ans, List<Integer> tempList, int tempSum, int[] candidates, int target, int startIdx) {
        if (tempSum == target) {
            ans.add(new ArrayList<>(tempList));
            return;
        }
        if (tempSum > target) {
            return;
        }
        for (int i = startIdx; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            tempSum += candidates[i];
            backtrack(ans, tempList, tempSum, candidates, target, i);
            tempList.remove(tempList.size() - 1);
            tempSum -= candidates[i];
        }
    }
}
