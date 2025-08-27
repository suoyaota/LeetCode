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
}
