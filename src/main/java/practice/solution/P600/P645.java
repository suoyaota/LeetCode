package practice.solution.P600;

import java.util.Arrays;



/**
 * @Author William Wang
 */
public class P645 {

    //直接排序然后寻找
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int dup = -1;
        int missing = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                dup = nums[i];
            }
            if (nums[i] == nums[i - 1] + 2) {
                missing = nums[i - 1] + 1;
            }
        }

        //1miss检测不到，故missing初始化为1
        //最后一个miss也检测不到
        if (nums[nums.length - 1] != nums.length) {
            //最后一个miss
            missing = nums.length;
        }
        return new int[]{dup, missing};
    }

    //O(N) 的时间复杂度、O(1) 空间复杂度
    public int[] findErrorNums2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                //把位置i的数换到它正确的位置上，如果不用换那它就是重复的数
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        return null;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
