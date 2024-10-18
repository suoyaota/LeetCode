package practice.solution;

/**
 * @Author William Wang
 */
public class P665 {

    //有点递归的思想 对于每一个i我们默认i之前的都是递增序列（包括等于）， 然后当i不符合时判断是调整i还是调整i-1
    public boolean checkPossibility(int[] nums) {
        int wrong = 0;
        for (int i = 1; i < nums.length && wrong < 2; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            wrong++;
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
        }
        return wrong < 2;
    }
}

