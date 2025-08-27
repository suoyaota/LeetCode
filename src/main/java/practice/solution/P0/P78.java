package practice.solution.P0;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author WilliamWang
 * @Date 2025/8/6-17:02
 */

@Component
public class P78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        List<Integer> list = new ArrayList<>();
        ans.add(list);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<List<Integer>> tempAns = new ArrayList<>();
            for (List<Integer> oldList : ans) {
                List<Integer> newSubLists = new ArrayList<>(oldList);
                newSubLists.add(num);
                tempAns.add(newSubLists);
            }
            ans.addAll(tempAns);
        }
        return ans;
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtracking(0, nums, tempList, ans);
        return ans;
    }
    // 第i层迭代就是在选第i个数
    private void backtracking(int idx, int[] nums, List<Integer> tempList, List<List<Integer>> ans) {
        // 第一次进入什么数都不选，加入空集
        // 每一层，每次进入，数都不一样，故加入答案
        ans.add(new ArrayList<>(tempList));
        // 从第idx位置开始选第idx+1个数
        // idx = 0时，即选择第1个数
        for (int i = idx; i < nums.length; i++) {
            tempList.add(nums[i]);
            // 第1个数已选完，准备选第2个数
            backtracking(i + 1, nums, tempList, ans);
            // 第1个数不选当前值，准备进入循环选下一个值
            tempList.remove(tempList.size() - 1);
        }
    }


    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtracking(0, ans, tempList, nums);
        return ans;
    }
    private void backtracking(int idx, List<List<Integer>> ans, List<Integer> tempList, int[] nums) {
        // 所有数都考虑过了就加入ans
        if (idx == nums.length) {
            ans.add(new ArrayList<>(tempList));
            return;
        }
        // 加入当前数
        tempList.add(nums[idx]);
        // 考虑下一个数
        backtracking(idx + 1, ans, tempList, nums);
        // 不要当前数
        tempList.remove(tempList.size() - 1);
        backtracking(idx + 1, ans, tempList, nums);
    }


}
