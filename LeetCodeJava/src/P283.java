/**
 * @author wyb
 */
public class P283 {
    class Solution1 {
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
    }

    class Solution2 {
        public void moveZeroes(int[] nums) {
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
    }
}
