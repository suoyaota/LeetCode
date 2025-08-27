package practice.solution.P600;

/**
 * @Author William Wang
 */
public class P647 {

    private int ans;

    public int countSubstrings(String s) {
        //回文串以它的中心去扩展的话，是不会重复的
        for (int i = 0; i < s.length(); i++) {
            getPalindromicSubstrings(s, i, i); //奇数长度
            getPalindromicSubstrings(s, i, i + 1); //偶数长度
        }
        return ans;
    }

    private void getPalindromicSubstrings(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            ans++;
            start--;
            end++;
        }
    }
}

