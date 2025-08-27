package practice.solution.P600;


/**
 * @Author William Wang
 */
public class P696 {

    //较慢 尝试拓展
    private int ans;

    public int countBinarySubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                extendSubstrings10(s, i, i + 1);
            }
            if (s.charAt(i) == '0') {
                extendSubstrings01(s, i, i + 1);
            }
        }
        return ans;
    }

    private void extendSubstrings10(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == '1' && s.charAt(end) == '0') {
            ans++;
            start--;
            end++;
        }
    }

    private void extendSubstrings01(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == '0' && s.charAt(end) == '1') {
            ans++;
            start--;
            end++;
        }
    }

    //较快
    public int countBinarySubstrings2(String s) {
        //出现一个不同就能消灭一个0或1，得分就加1
        int ansPoint = 0, hasLen = 0, tempLen = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                tempLen++;
            } else {
                //如果不同了，现在拥有的串就变成了待消耗的串
                hasLen = tempLen;
                tempLen = 1;
            }
            if (hasLen >= tempLen) {
                ansPoint++;
            }
        }
        return ansPoint;
    }
}
