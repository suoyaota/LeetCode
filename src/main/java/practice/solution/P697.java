package practice.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author William Wang
 */
public class P697 {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> numCnt = new HashMap<>();
        Map<Integer, Integer> numStartIdx = new HashMap<>();
        Map<Integer, Integer> numEndIdx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numCnt.put(nums[i], numCnt.getOrDefault(nums[i], 0) + 1);
            if (!numStartIdx.containsKey(nums[i])) {
                numStartIdx.put(nums[i], i);
            }
            numEndIdx.put(nums[i], i);
        }
        int degree = 0;
        for (int num : numCnt.keySet()) {
            degree = Math.max(degree, numCnt.get(num));
        }
        int ans = nums.length;
        for (int num : numCnt.keySet()) {
            if (numCnt.get(num) != degree) {
                continue;
            }
            ans = Math.min(ans, numEndIdx.get(num) - numStartIdx.get(num) + 1);
        }
        return ans;
    }
}

