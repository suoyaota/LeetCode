package practice.solution.P200;

import org.springframework.stereotype.Component;

/**
 * @Author William Wang
 * @Date 2019/10/10 11:08
 */
@Component
public class P275 {
    /**
     * @Date 2019/10/10 11:08
     * @Author William Wang
     * @description 二分，时间O（logn）,注意二分的对象，这里是[0,length]的范围，
     * 因为ans=0和length=0的情况会引起数组越界，故先排除。缩小
     * ans范围至[1,length]后二分。
     * Runtime:100%，Memory Usage:100%
     */


    public int hIndex(int[] citations) {
        if (citations.length == 0 || citations[citations.length - 1] == 0) {
            return 0;
        }
        int min = 1;
        int max = citations.length;
        int ans = 1;
        int mid = 0;
        while (min <= max) {
            mid = (min + max) / 2;
            if (citations[citations.length - mid] >= mid) {
                min = mid + 1;
                ans = mid;
            } else {
                max = mid - 1;
            }
        }
        return ans;
    }
}

