package practice.solution;

import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @Author William Wang
 * @Date 2019/10/11 9:21
 */
@Component
public class P219 {
    /**
     * @Date 2019/10/11 9:21
     * @Author William Wang
     * @description HashMap. Runtime:82.54%  Memory Usage:86.84%
     */

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i]) - i) <= k) {
                    return true;
                } else {
                    //.remove(nums[i]);
                    map.put(nums[i], i);
                }
            } else {
                //map.remove(nums[i]);
                map.put(nums[i], i);
            }
        }
        return false;
    }
}

