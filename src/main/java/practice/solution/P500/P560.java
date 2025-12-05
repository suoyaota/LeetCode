package practice.solution.P500;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author WilliamWang
 * @Date 2025/11/20-10:04
 */

@Component
public class P560 {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>(len);
        map.put(0, 1);
        for (int i = 0; i < len; i++) {
            sum = sum + nums[i];
            int tempAns = map.getOrDefault(sum - k, 0);
            ans += tempAns;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
