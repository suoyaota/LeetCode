package practice.solution;

import org.springframework.stereotype.Component;

/**
 * @Date 2019/10/9 18:24
 * @Author William Wang
 */
@Component
public class P136 {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int n : nums) {
            ans ^= n;
        }
        return ans;
    }
}

