package practice.solution;

import org.springframework.stereotype.Component;

/**
 * @Author William Wang
 * @Date 2019/10/19 10:58
 */
@Component
public class P330 {

    /**
     * @Date 2019/10/19 10:58
     * @Author William Wang
     * @Desicription Runtime & Memory Usage: 100.00%
     * 一开始我们能表示的范围是[1,max),即[1,1)
     * 如果nums[i]<=max 意味着我们可以把表示范围扩大到max+nums[i])
     * 如果没有就加一个数，最贪心的方式就是加一个max进去
     */
    public int minPatches(int[] nums, int n) {
        long max = 1;
        int ans = 0;
        int i = 0;
        while (max <= n) {
            if (i < nums.length && nums[i] <= max) {
                max += nums[i];
                i++;
            } else {
                max += max;
                ans++;
            }
        }
        return ans;
    }
}

