package practice.solution;

import org.springframework.stereotype.Component;

/**
 * @Author William Wang
 * @Date 2019/10/28 23:50
 */
@Component
public class P58 {

    /**
     * @Date 2019/10/28 23:51
     * @Author William Wang
     * @Desicription 两种方法均是双100.00%
     */
    public int lengthOfLastWord(String s) {
        //return s.trim().length()-s.trim().lastIndexOf(" ")-1;
        if (s == "") {
            //s.length == 0 均可
            return 0;
        }
        int last = s.length() - 1;
        int ans = 0;
        while (last >= 0 && s.charAt(last) == ' ') {
            last--;
        }
        while (last >= 0 && s.charAt(last) != ' ') {
            last--;
            ans++;
        }
        return ans;
    }
}

