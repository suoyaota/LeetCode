import java.util.HashMap;

/**
 * @author William Wang
 * @date 2019/10/11 9:21
 */
public class P219 {
/**
 *@date 2019/10/11 9:21
 *@author William Wang
 *@description HashMap. Runtime:82.54%  Memory Usage:86.84%
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i]) - i) <= k) {
                    return true;
                } else {
                    //.remove(nums[i]);
                    map.put(nums[i],i);
                }
            } else {
                //map.remove(nums[i]);
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
}
