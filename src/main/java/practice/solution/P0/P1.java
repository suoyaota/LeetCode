package practice.solution.P0;

import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @Author William Wang
 */
@Component
public class P1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashmap.containsKey(nums[i])) {
                return new int[]{hashmap.get(nums[i]), i};
            }
            hashmap.put(target - nums[i], i);
        }
        return null;
    }
}
