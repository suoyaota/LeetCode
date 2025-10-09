package practice.solution.P0;

import org.springframework.stereotype.Component;

/**
 * @Author William Wang
 */
@Component
public class P34 {

    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findFirst(nums, target + 1) - 1;
        if (first == nums.length || nums[first] != target) {
            //目标大于所有元素||没有该元素
            return new int[]{-1, -1};
        } else {
            return new int[]{first, Math.max(first, last)};
        }
    }

    private int findFirst(int[] nums, int target) {
        //找到target开始的位置 或者 刚刚大于target元素开始的位置
        int l = 0;
        int h = nums.length; //此处h取值要考虑target大于所有元素的情况
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return l;
    }

    public int[] searchRange2(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        if (nums == null || nums.length == 0) {
            return ans;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while (right >= left) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (nums[mid] != target) {
            return ans;
        }
        ans[0] = findLowIdx(nums, 0, mid, target);
        ans[1] = findHighIdx(nums, mid, nums.length - 1, target);
        return ans;
    }

    private int findLowIdx(int[] nums, int startIdx, int endIdx, int target) {
        int mid = (startIdx + endIdx) / 2;
        while (endIdx > startIdx) {
            mid = (startIdx + endIdx) / 2;
            if (nums[mid] < target) {
                startIdx = mid + 1;
            } else {
                endIdx = mid;
            }
        }
        return startIdx;
    }

    private int findHighIdx(int[] nums, int startIdx, int endIdx, int target) {
        int mid = (startIdx + endIdx) / 2 + 1;
        while (endIdx > startIdx) {
            mid = (startIdx + endIdx) / 2 + 1;
            if (nums[mid] > target) {
                endIdx = mid - 1;
            } else {
                startIdx = mid;
            }
        }
        return startIdx;
    }
}
