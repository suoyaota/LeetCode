package practice.solution;

/**
 * @author William Wang
 * @date 2020/3/26 7:59
 */
public class P693 {
    /**
     * @date 2020/3/26 7:59
     * @author William Wang
     * @description 如果是交替数，则a为全1的二进制数
     */

    public boolean hasAlternatingBits(int n) {
        int a = n ^ (n >> 1);
        boolean ans = (a & (a + 1)) == 0;
        return ans;
    }
}
