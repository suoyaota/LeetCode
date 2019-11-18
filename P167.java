/**
 * @author William Wang
 * @date 2019/11/18 20:31
 */
public class P167 {
/**
 *@date 2019/11/18 20:31
 *@author William Wang
 *@description
 */
class Solution {
    /**
     *@Date 2019/11/18 20:32
     *@Author William Wang
     *@Desicription 双指针 Runtime 100.00% Memory Usage 31.34%
     */
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (numbers[i] + numbers[j] != target) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        int[] ans = new int[]{i+1, j+1};
        return ans;
    }
}
}
