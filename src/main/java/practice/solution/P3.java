package practice.solution;

import org.springframework.stereotype.Component;

/**
 * @Author William Wang
 * @Date 2019/11/12 21:53
 */
@Component
public class P3 {

    /**
     * @Date 2019/11/12 21:53
     * @Author William Wang
     * @Desicription
     */
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int ans = 0;
        int[] lastShow = new int[128];
        for (int i = 0, j = 0; j < len; j++) {
            i = Math.max(i, lastShow[s.charAt(j)]);
            ans = Math.max(ans, j - i + 1);
            lastShow[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}

