/**
 * @author William Wang
 * @date 2019/11/27 21:28
 */
public class P680 {
    /**
     * @author William Wang
     * @date 2019/11/27 21:28
     * @description
     */
    class Solution {
        public boolean validPalindrome(String s) {
            int i = 0;
            int j = s.length() - 1;
            while (i <= j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return isPalindrome(i, j - 1, s) || isPalindrome(i + 1, j, s);
                }
                i++;
                j--;
            }
            return true;
        }

        public boolean isPalindrome(int i, int j, String s) {
            while (i <= j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }
}
