package practice.solution.P300;

import org.springframework.stereotype.Component;

/**
 * @Author William Wang
 * @Date 2019/10/23 15:06
 */
@Component
public class P321 {


    /**
     * @Date 2019/10/23 15:06
     * @Author William Wang
     * @Desicription Runtime: 35.00%   Memory Usage: 100.00%
     * <p>
     * 两无序数组归并
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = Math.min(nums1.length, k);
        int[] ans = new int[k];
        for (int i = 0; i <= len1; i++) {
            if (nums2.length < k - i) {
                //要在nums2中取k-i个数
                continue;
            }
            int[] maxNum1 = new int[i];
            int[] maxNum2 = new int[k - i];
            maxNum1 = getMaxNum(nums1, i);
            maxNum2 = getMaxNum(nums2, k - i);
            int[] tempAns = new int[k];
            tempAns = merge(maxNum1, maxNum2, k);

            // System.out.println(Arrays.toString(tempAns));
            // System.out.println(Arrays.toString(ans));

            if (compareAns(tempAns, ans)) {
                System.arraycopy(tempAns, 0, ans, 0, k);
            }
        }
        return ans;
    }

    public int[] getMaxNum(int[] nums, int n) {
        int[] maxNum = new int[n];
        int start = 0;
        int end = nums.length - n;
        for (int i = 0; i < n; i++) {
            for (int j = start; j <= end; j++) {
                if (nums[j] > maxNum[i]) {
                    maxNum[i] = nums[j];
                    start = j + 1;
                }
                if (maxNum[i] == 9) {
                    break;
                }
            }
            end++;
        }
        return maxNum;
    }

    public int[] merge(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0) {
            return nums2;
        }
        if (nums2.length == 0) {
            return nums1;
        }
        int[] mergedNums = new int[k];
        int m = 0;
        int n = 0;
        for (int i = 0; i < k; i++) {
            if (n == nums2.length || m != nums1.length && greaterNum(nums1, nums2, m, n)) {
                //此处归并条件的判断最关键。可能出现连续相等的情况，要一直向后比较然后采用较大数的开头。
                mergedNums[i] = nums1[m];
                m++;
            } else {
                mergedNums[i] = nums2[n];
                n++;
            }
        }
        return mergedNums;
    }

    public boolean greaterNum(int[] maxNums, int[] minNums, int m, int n) {

        while (true) {
            if (m == maxNums.length) {
                return false;
            }
            if (n == minNums.length) {
                return true;
            }
            if (maxNums[m] > minNums[n]) {
                return true;
            } else if (maxNums[m] == minNums[n]) {
                m++;
                n++;
            } else {
                return false;
            }
        }
    }

    public boolean compareAns(int[] maxNums, int[] minNums) {
        for (int i = 0; i < maxNums.length; i++) {
            if (maxNums[i] < minNums[i]) {
                return false;
            } else if (maxNums[i] == minNums[i]) {
                continue;
            } else {
                return true;
            }
        }
        return false;
    }
}

