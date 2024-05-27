import java.util.HashSet;
import java.util.Set;

/**
 * @author William Wang
 * @date 2019/10/17 9:16
 */
public class P128 {
    class Solution {
        /**
         *@Date 2019/10/17 9:16
         *@Author William Wang
         *@Desicription Runtime:83.80%  Memory Usage:98.28%
         */
        public int longestConsecutive(int[] nums) {
            Set<Integer> numSet = new HashSet<>();
            for (int x : nums) {
                numSet.add(x);
            }
            int tempLength = 0;
            int ans = 0;
            for (int x : numSet) {
                if (!numSet.contains(x - 1)) {
                    tempLength = 0;
                    //int currentNum = x;
                    while (numSet.contains(x)) {
                        tempLength++;
                        x++;
                    }
                    ans = Math.max(ans,tempLength);
                }
            }
            return ans;
        }
    }
}
