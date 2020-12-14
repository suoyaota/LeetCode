/**
 * @author wyb
 */
public class P409 {
    class Solution {
        public int longestPalindrome(String s) {
            int[] charNum = new int[256];
            for (char c : s.toCharArray()) {
                charNum[c]++;
            }
            int ans = 0;
            for (int num : charNum) {
                ans += (num / 2) * 2;
            }
            return ans < s.length() ? ans + 1 : ans;
        }
    }
}
