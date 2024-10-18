package practice.solution;


/**
 * @Author William Wang
 * @Date 2020/2/24 14:12
 */
public class p461 {
    /**
     * @Date 2020/2/24 14:12
     * @Author William Wang
     * @description 位运算
     */

    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int ans = 0;
        while (z != 0) {
            if ((z & 1) == 1) {
                ans++;
            }
            z = z >> 1;
        }
        return ans;
    }

    public int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistance3(int x, int y) {
        int z = x ^ y;
        int ans = 0;
        while (z != 0) {
            z = z & (z - 1);
            ans++;
        }
        return ans;
    }
}

