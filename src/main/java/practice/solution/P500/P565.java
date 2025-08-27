package practice.solution.P500;

/**
 * @Author William Wang
 */
public class P565 {

    public int arrayNesting(int[] nums) {
        //每个数只能处于一个S里，所以把已经访问过的标记为-1,含有-1的S不必再统计了
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = i; nums[j] != -1; ) {
                cnt++;
                int nextIdx = nums[j];
                nums[j] = -1;
                j = nextIdx;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}

