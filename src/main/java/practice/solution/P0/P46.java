package practice.solution.P0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author WilliamWang
 * @Date 2025/8/6-14:45
 */


public class P46 {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList();
        for (int num : nums) {
            list.add(num);
        }
        backtrack(ans, 0, list);
        return ans;
    }
    private void backtrack(List<List<Integer>> ans, int idx, List<Integer> output) {
        if (idx == output.size()) {
            ans.add(new ArrayList<>(output));
        }
        // 余下的数依次填到idx位置上
        for (int i = idx; i < output.size(); i++) {
            Collections.swap(output, idx, i);
            backtrack(ans, idx + 1, output);
            Collections.swap(output, idx, i);
        }
    }
}
