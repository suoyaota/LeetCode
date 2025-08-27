package practice.solution.P100;

import org.springframework.stereotype.Component;

/**
 * @Date 2019/10/9 18:27
 * @Author William Wang
 */
@Component
public class P189 {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) return;
        int moveNum = 0;
        int location = 0;
        int temp0 = nums[0];
        int temp1 = 0;
        int nowLoc = 0;
        while (moveNum < nums.length) {
            int tar = (nowLoc + k) % nums.length;
            temp1 = nums[tar];
            nums[tar] = temp0;
            nowLoc = tar;
            moveNum++;
            temp0 = temp1;
            if (tar == location) {
                location++;
                nowLoc = location;
                temp0 = nums[nowLoc];
            }
        }
    }
}


