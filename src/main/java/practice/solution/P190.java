package practice.solution;

import org.springframework.stereotype.Component;

/**
 * @author William Wang
 * @date 2020/2/25 9:46
 */
@Component
public class P190 {
    /**
     * @date 2020/2/25 9:46
     * @author William Wang
     * @description
     */
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans |= (n & 1);
            n >>>= 1;
        }
        return ans;
    }
}

