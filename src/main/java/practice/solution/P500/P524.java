package practice.solution.P500;

import java.util.List;

/**
 * @Author William Wang
 */
public class P524 {

    //依次判断
    //很慢  9.84    8.71
    public String findLongestWord(String s, List<String> d) {
        String ans = "";
        for (String curString : d) {
            int l1 = ans.length();
            int l2 = curString.length();
            if (l2 > l1 || l1 == l2 && curString.compareTo(ans) < 0) {
                if (isSubStr(s, curString)) {
                    ans = curString;
                }
            }
        }
        return ans;
    }

    private boolean isSubStr(String s, String sub) {
        if (s == null) {
            return false;
        }
        int i = 0, j = 0;
        int subLen = sub.length() - 1;
        int sLen = s.length() - 1;
        while (i <= sLen && j <= subLen) {
            if (s.charAt(i) == sub.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == subLen + 1;
    }
}
