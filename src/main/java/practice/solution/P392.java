package practice.solution;

import org.springframework.stereotype.Component;



/**
 * @author wyb
 */
@Component
public class P392 {

    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (t == null || t.length() == 0) {
            return false;
        }
        int slen = s.length();
        int tlen = t.length();
        int sIdx = 0;
        int tIdx = 0;
        int rightNum = 0;
        while (sIdx < slen && tIdx < tlen) {
            if (s.charAt(sIdx) == t.charAt(tIdx)) {
                rightNum++;
                sIdx++;
            }
            tIdx++;
        }
        return rightNum == slen;
    }

    public boolean isSubsequence2(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            //从index + 1的位置找c 并返回c的下标
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}

