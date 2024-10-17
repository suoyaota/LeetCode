package practice.solution;

import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author William Wang
 * @date 2019/10/18 14:48
 */
@Component
public class P164 {

    /**
     * @Date 2019/10/18 14:48
     * @Author William Wang
     * @Desicription Runtime: 98.17%  Memory Usage: 100.00%
     * 核心思想是最大间距会出现在空桶两旁
     */
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int min = nums[0];
        int max = nums[0];
        for (int x : nums) {
            if (x > max) {
                max = x;
            }
            if (x < min) {
                min = x;
            }
        }
        if (min == max) {
            return 0;
        }
        int bucketNum = len + 1;//抽屉原理（鸽洞原理），最大Gap会在空桶附近出现。
        int bucketLength = (int) Math.ceil((double) (max - min) / bucketNum);//这样取也可能没有空桶出现，但仍能求出结果。
        int[] maxOfEachBucket = new int[bucketNum];
        int[] minOfEachBucket = new int[bucketNum];
        Arrays.fill(maxOfEachBucket, -1);
        Arrays.fill(minOfEachBucket, -1);
        for (int x : nums) {
            int index = (x - min) / bucketLength;
            if (x == max) {
                //如果没这个判断，等间距的情况max会被放在index = bucketNum - 2的桶里，导致bucketNum - 1是空桶
                index = bucketNum - 1;
            }
            if (minOfEachBucket[index] == -1 || x < minOfEachBucket[index]) {
                minOfEachBucket[index] = x;
            }
            if (maxOfEachBucket[index] == -1 || x > maxOfEachBucket[index]) {
                maxOfEachBucket[index] = x;
            }
        }
        int preMax = maxOfEachBucket[0];
        int ans = 0;
        for (int i = 1; i < bucketNum; i++) {
            if (minOfEachBucket[i] != -1 && minOfEachBucket[i - 1] == -1) {
                ans = Math.max(ans, minOfEachBucket[i] - preMax);
            }
            if (minOfEachBucket[i] != -1 && (i + 1) != bucketNum && minOfEachBucket[i + 1] == -1) {
                preMax = maxOfEachBucket[i];
            }

        }
        return ans;
    }
}

