import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author William Wang
 * @date 2019/10/10 11:37
 */
public class P217 {
/**
 *@date 2019/10/10 11:37
 *@author William Wang
 *@description
 */

class Solution1 {
    /**
     *@Date 2019/10/10 11:37
     *@Author William Wang
     *@Desicription 排序 时间O（nlogn），空间O（1）
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return true;
            }
        }
        return false;
    }
}
    class Solution2 {
    /**
     *@Date 2019/10/10 11:43
     *@Author William Wang
     *@Desicription Runtime:21.10%  Memory Usage: 62.07%
     */
        public boolean containsDuplicate(int[] nums) {
            if (nums.length == 0 || nums.length == 1) {
                return false;
            }
            Set<Integer> set = new HashSet<>(nums.length);
            for (int n: nums) {
                if (set.contains(n)) {
                    return true;
                }
                set.add(n);
            }
            return false;
        }
    }
}
