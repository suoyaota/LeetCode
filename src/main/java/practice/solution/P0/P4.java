package practice.solution.P0;

/**
 * @Author William Wang
 * @Date 2019/10/20 23:52
 */
public class P4 {

    /**
     * @Date 2019/10/20 23:53
     * @Author William Wang
     * @Desicription 找中位数分情况讨论。 Runtime:99.97; Memory Usage: 90.97%
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            if (nums2.length % 2 == 1) {
                return (double) nums2[nums2.length / 2];
            } else {
                return ((double) nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) * 0.5;
            }
        }
        if (nums2.length == 0) {
            if (nums1.length % 2 == 1) {
                return (double) nums1[nums1.length / 2];
            } else {
                return ((double) nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) * 0.5;
            }
        }

        int len1 = nums1.length;
        int len2 = nums2.length;
        double ans = 0;
        if ((len1 + len2) % 2 == 1) {
            int i = 0;
            int j = 0;
            while ((i + j) != (len1 + len2) / 2 + 1) {
                if (j == len2 || i != len1 && nums1[i] < nums2[j]) {
                    ans = nums1[i];
                    i++;
                } else if (i == len1 || nums1[i] >= nums2[j]) {
                    ans = nums2[j];
                    j++;
                }
            }
        } else {
            int i = 0;
            int j = 0;
            while ((i + j) != (len1 + len2) / 2) {
                if (j == len2 || i != len1 && nums1[i] < nums2[j]) {
                    ans = nums1[i];
                    i++;
                } else if (i == len1 || nums1[i] >= nums2[j]) {
                    ans = nums2[j];
                    j++;
                }
            }
            if (j == len2 || i != len1 && nums1[i] < nums2[j]) {
                ans = 0.5 * (nums1[i] + ans);
            } else if (i == len1 || nums1[i] >= nums2[j]) {
                ans = 0.5 * (nums2[j] + ans);
            }
        }
        return ans;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int tarNum = (m + n) / 2 + 1;
        int f = -1;
        int s = -1;
        int i = 0;
        int j = 0;
        for (int num = 0; num < tarNum; num++) {
            int next = 0;
            if (i == m) {
                j++;
                next = nums2[j - 1];
            } else if (j == n) {
                i++;
                next = nums1[i - 1];
            } else if (nums1[i] < nums2[j]) {
                i++;
                next = nums1[i - 1];
            } else {
                j++;
                next = nums2[j - 1];
            }
            s = f;
            f = next;
        }
        if (m + n - tarNum * 2 == -1) {
            return f;
        } else {
            return (double) (f + s) / 2;
        }

    }
}

