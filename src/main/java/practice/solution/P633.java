package practice.solution;

/**
 * @Author William Wang
 * @Date 2019/11/20 19:49
 */
public class P633 {
/**
 *@Date 2019/11/20 19:49
 *@Author William Wang
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
