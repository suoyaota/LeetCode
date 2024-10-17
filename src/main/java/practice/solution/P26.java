package practice.solution;

import org.springframework.stereotype.Component;

@Component
public class P26 {

    public int removeDuplicates(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[idx]) {
                nums[++idx] = nums[i];
            }
        }
        return idx + 1;
    }
}

