import java.util.HashMap;

/**
 * @author wyb
 */
public class P594 {
    class Solution {
        public int findLHS(int[] nums) {
            HashMap<Integer, Integer> numWithCount = new HashMap<>();
            for (int num : nums) {
                numWithCount.put(num, numWithCount.getOrDefault(num, 0) + 1);
            }
            int ans = 0;
            for (int num: numWithCount.keySet()) {
                if (numWithCount.containsKey(num + 1)) {
                    ans = Math.max(ans, numWithCount.get(num) + numWithCount.get(num + 1));
                }
            }
            return ans;
        }
    }
}
