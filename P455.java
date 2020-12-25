import java.util.Arrays;

/**
 * @author wyb
 */
public class P455 {
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            if (g == null || s == null) {
                return 0;
            }
            Arrays.sort(g);
            Arrays.sort(s);
            int ans = 0;
            int gCnt = 0, sCnt = 0;
            while (gCnt < g.length && sCnt < s.length) {
                if (s[sCnt] >= g[gCnt]) {
                    ans++;
                    gCnt++;
                }
                sCnt++;
            }
            return ans;

        }
    }
}
