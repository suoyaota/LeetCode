package practice.solution;

import org.springframework.stereotype.Component;

@Component
public class P27 {

    public int removeElement(int[] nums, int val) {
        int ans = 0;
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                ans++;
            } else {
                nums[idx] = nums[i];
                idx++;
            }
        }
        return nums.length - ans;
    }
}

