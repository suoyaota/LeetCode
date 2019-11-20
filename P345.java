import java.util.Arrays;
import java.util.HashSet;

/**
 * @author William Wang
 * @date 2019/11/20 20:17
 */
public class P345 {
/**
 *@date 2019/11/20 20:17
 *@author William Wang
 *@description
 */
class Solution {
    /**
     *@Date 2019/11/20 20:17
     *@Author William Wang
     *@Desicription 双指针 Runtime 58.63% Memory Usage 100.00%
     */
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {

        int end = s.length() - 1;
        int start = 0;
        char[] result = new char[s.length()];
        while (start <= end) {
            char ss = s.charAt(start);
            char e = s.charAt(end);
            if (!vowels.contains(ss)) {
                result[start] = ss;
                start++;
            } else if (!vowels.contains(e)){
                result[end] = e;
                end--;
            } else {
                result[start++] = e;
                result[end--] = ss;
            }
        }
        return new String(result);
    }
}
}
