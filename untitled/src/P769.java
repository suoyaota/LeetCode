/**
 * @author wyb
 */
public class P769 {
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            //不断向右扩大，直到i追赶上right
            int ans = 0;
            int right = arr[0];
            for (int i = 0; i < arr.length; i++) {
                right = Math.max(right, arr[i]);
                if (i == right) {
                    ans++;
                }
            }
            return ans;
        }
    }
}
