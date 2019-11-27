/**
 * @author William Wang
 * @date 2019/11/27 20:22
 */
public class P9 {
    /**
     * @author William Wang
     * @date 2019/11/27 20:22
     * @description
     */
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0 || x % 10 == 0 && x != 0) {
                return false;
            }
            int toTest = 0;
            while (x > toTest) {
                toTest = toTest * 10 + x % 10;
                x = x / 10;
            }
            return x == toTest || x == toTest / 10;
        }
    }
}
