package practice.solution;

/**
 * @Author William Wang
 */
public class P485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int temp = 0;
        for (int num : nums) {
            if (num == 1) {
                temp++;

            } else {
                ans = Math.max(ans, temp);
                temp = 0;
            }
        }
        ans = Math.max(ans, temp);
        return ans;
    }
}

