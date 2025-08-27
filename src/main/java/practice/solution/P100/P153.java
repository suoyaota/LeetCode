package practice.solution.P100;

import org.springframework.stereotype.Component;

/**
 * @Author William Wang
 */
@Component
public class P153 {

    public int findMin(int[] nums) {
        //二分法是不在while里返回的，while只缩小查找范围
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] <= nums[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }
}

