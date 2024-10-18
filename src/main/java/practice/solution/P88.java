package practice.solution;

import org.springframework.stereotype.Component;


/**
 * @Author William Wang
 * @Date 2019/10/21 21:18
 */
@Component
public class P88 {

    /**
     * @Date 2019/10/21 21:18
     * @Author William Wang
     * @Desicription Runtime & Memory Usage: 100.00%
     * 简单归并
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int[] ans = new int[m + n];
        for (int t = 0; t < m + n; t++) {
            if (j == n || i != m && nums1[i] < nums2[j]) {
                // nums2用完了或者 nums1没用完并且nums1的数小
                ans[t] = nums1[i];
                i++;
            } else {
                ans[t] = nums2[j];
                j++;
            }
        }
        if (m + n >= 0) System.arraycopy(ans, 0, nums1, 0, m + n);
    }

    //不用新开数组，从尾开始归并
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int curIdx = nums1.length - 1;
        m--;
        n--;
        while (m >= 0 || n >= 0) {
            if (m < 0) {
                nums1[curIdx--] = nums2[n--];
            } else if (n < 0) {
                nums1[curIdx--] = nums1[m--];
            } else if (nums1[m] > nums2[n]) {
                nums1[curIdx--] = nums1[m--];
            } else {
                nums1[curIdx--] = nums2[n--];
            }
        }
    }

    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int curIdx = m + n - 1;
        m--;
        n--;
        while (n >= 0) {
            if (m >= 0 && nums1[m] > nums2[n]) {
                nums1[curIdx--] = nums1[m--];
            } else {
                nums1[curIdx--] = nums2[n--];
            }
        }
    }
}

