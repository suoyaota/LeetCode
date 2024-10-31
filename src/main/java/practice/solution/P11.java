package practice.solution;

import org.springframework.stereotype.Component;

/**
 * @Author William Wang
 * @Date 2019/10/16 0:00
 */
@Component
public class P11 {

    /**
     * @Date 2019/10/16 0:00
     * @Author William Wang
     * @Desicription Runtime:95.05%   Memory Usage:98.72%
     * 从最大宽度（即从左右两头）开始尝试，不断调整矮的一端，以期获得更高的隔板。
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = Math.min(height[left], height[right]) * (right - left);
        while (left != right) {
            if (height[left] <= height[right]) {
                left++;
                ans = Math.max(Math.min(height[left], height[right]) * (right - left), ans);
            } else {
                right--;
                ans = Math.max(Math.min(height[left], height[right]) * (right - left), ans);
            }
        }
        return ans;
    }

    public int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while(left < right) {
            int h = Math.min(height[right], height[left]);
            int temp = h * (right - left);
            ans = Math.max(ans, temp);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}

