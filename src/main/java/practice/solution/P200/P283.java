package practice.solution.P200;

import org.springframework.stereotype.Component;



/**
 * @Author William Wang
 */
@Component
public class P283 {

    public void moveZeroes(int[] nums) {
        int startIdx = -1;//开始出现0的下标 为-1代表之前没有0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                //是0
                if (startIdx == -1) {
                    startIdx = i;
                }
            } else {
                //不是0
                if (startIdx != -1 && nums[startIdx] == 0) {
                    nums[startIdx] = nums[i];
                    nums[i] = 0;
                    startIdx++;
                } else {
                    startIdx = -1;
                }
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int idx = 0;//非0的下标
        for (int num : nums) {
            if (num != 0) {
                nums[idx++] = num;
            }
        }
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }

    public void moveZeroes3(int[] nums) {
        int zeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (zeroIndex == -1) {
                    zeroIndex = i;
                }
                continue;
            } else if (zeroIndex != -1) {
                nums[zeroIndex] = nums[i];
                zeroIndex++;
                nums[i] = 0;
            }
        }
    }
}
