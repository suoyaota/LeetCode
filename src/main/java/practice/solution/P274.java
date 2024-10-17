package practice.solution;

import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Date 2019/10/8 16:52
 * @Author William Wang
 */
@Component
public class P274 {

    /**
     * @Date 2019/10/9 15:36
     * @Author William Wang
     * @Desicription 先排序，从大数开始试
     */
    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int ans = 0;
        for (ans = citations.length; ans > 0; ans--) {
            if (citations[citations.length - ans] >= ans) {
                break;
            }
        }
        return ans;
    }
}

