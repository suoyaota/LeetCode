package practice.solution;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author WilliamWang
 * @Date 2024/10/24-11:09
 */

@Component
public class P15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int startNum = nums[0];
        for (int start = 0; start < nums.length; start++) {
            if (start != 0 && nums[start] == startNum) {
                continue;
            }
            startNum = nums[start];
            int left = start + 1;
            int right = nums.length - 1;
            while (left < right) {
                int temp = nums[start] + nums[left] + nums[right];
                if (temp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[start]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                }
                if (temp <= 0) {
                    left++;
                    while(left < right - 1 && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
                if (temp >= 0) {
                    right--;
                    while(right > left + 1 && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
