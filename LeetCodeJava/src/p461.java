/**
 * @author William Wang
 * @date 2020/2/24 14:12
 */
public class p461 {
    /**
     *@date 2020/2/24 14:12
     *@author William Wang
     *@description  位运算
     */
    class Solution1 {
        public int hammingDistance(int x, int y) {
            int z = x ^ y;
            int ans = 0;
            while(z != 0) {
                if((z & 1) == 1) {
                    ans++;
                }
                z = z >> 1;
            }
            return ans;
        }
    }

    class Solution2 {
        public int hammingDistance(int x, int y) {
            return Integer.bitCount(x ^ y);
        }
    }
    class Solution3 {
        public int hammingDistance(int x, int y) {
            int z = x ^ y;
            int ans = 0;
            while(z != 0) {
                z = z & (z - 1);
                ans++;
            }
            return ans;
        }
    }
}
