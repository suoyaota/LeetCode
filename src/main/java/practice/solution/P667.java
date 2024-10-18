package practice.solution;

/**
 * @Author William Wang
 */
public class P667 {

    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1, interval = k; i <= k; i++, interval--) {
            if (i % 2 == 1) {
                ans[i] = ans[i - 1] + interval;
            } else {
                ans[i] = ans[i - 1] - interval;
            }
        }
        for (int i = k + 1; i < n; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }
}

