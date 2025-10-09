package practice.solution.P0;

import org.springframework.stereotype.Component;

/**
 * @Author WilliamWang
 * @Date 2025/9/25-14:23
 */

@Component
public class P33 {
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        int ans = -1;
        while (h > l) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (
                // 剩2个时右边没空间
                    mid == l
                            // 右边正常区间
                            || nums[h] > nums[mid] && target > nums[mid] && target <= nums[h]
                            // 右边非正常区间
                            || nums[h] < nums[mid] && (target <= nums[h] || target > nums[mid])) {
                // 搜右边
                l = mid + 1;
            } else {
                // 搜左边
                h = mid - 1;
            }
        }
        if (nums[l] == target) {
            return l;
        } else {
            return -1;
        }
    }
}
