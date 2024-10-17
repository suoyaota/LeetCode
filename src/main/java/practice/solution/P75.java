package practice.solution;

import org.springframework.stereotype.Component;


/**
 * @author William Wang
 * @date 2019/10/22 23:55
 */
@Component
public class P75 {

    /**
     * @Date 2019/10/22 23:56
     * @Author William Wang
     * @Desicription Runtime: 100% ; Memory Usage:99.21%
     */
    public void sortColors(int[] nums) {
        int pos0 = 0;
        int pos2 = nums.length - 1;
        int temp = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != 2) {
                pos2 = i;
                break;
            }
        }
        for (int i = 0; i < pos2 + 1; i++) {
            if (nums[i] == 0) {
                temp = nums[pos0];
                nums[pos0] = nums[i];
                nums[i] = temp;
                pos0++;
            } else if (nums[i] == 2) {
                temp = nums[pos2];
                nums[pos2] = nums[i];
                nums[i] = temp;
                pos2--;
                i--;
            }
        }
    }

    //三向切分方法
//注意if和 else if 效果是不同的！
    public void sortColors2(int[] nums) {
        int start1 = 0;
        int end1 = nums.length - 1;
        for (int i = 0; i <= end1; ) {
            if (nums[i] == 0) {
                swap(nums, i, start1);
                start1++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, end1);
                end1--;
            } else if (nums[i] == 1) {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
