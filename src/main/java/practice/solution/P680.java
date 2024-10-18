package practice.solution;

/**
 * @Author William Wang
 * @Date 2019/11/27 21:28
 */
public class P680 {
    /**
     * @Author William Wang
     * @Date 2019/11/27 21:28
     * @description
     */

    //不能出现错误就跳过错误的字母后继续判断，因为当min、max所在字母都可以被跳过时就无法选择了
    //所以必须写出判断回文的函数，然后尝试跳过某个字母；
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(i, j - 1, s) || isPalindrome(i + 1, j, s);
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome(int i, int j, String s) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

