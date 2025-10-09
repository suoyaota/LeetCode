package practice.solution.P0;

import org.springframework.stereotype.Component;

/**
 * @Author WilliamWang
 * @Date 2025/9/12-15:07
 */

@Component
public class P35 {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid = (l + r) / 2;
        while (r >= l) {
            mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        if (nums[mid] < target) {
            return mid + 1;
        }
        return mid;
    }
}
