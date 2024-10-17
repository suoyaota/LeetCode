package practice.solution;

/**
 * @author William Wang
 * @date 2019/11/20 19:49
 */
public class P633 {
/**
 *@date 2019/11/20 19:49
 *@author William Wang
 *@description
 */

    /**
     * @Date 2019/11/20 19:50
     * @Author William Wang
     * @Desicription 双指针 Runtime 95.54% Memory Usage 7.14%
     */
    public boolean judgeSquareSum(int c) {
        int max = (int) Math.sqrt(c);
        int min = 0;
        while (min <= max) {
            int tar = min * min + max * max;
            if (tar == c) {
                return true;
            } else if (tar < c) {
                min++;
            } else {
                max--;
            }
        }
        return false;
    }

}
