package practice.solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author William Wang
 */
public class P435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        //Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        //lambda表达式更慢一些
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] < o2[1]) ? -1 : (o1[1] == o2[1] ? 0 : 1);
            }
        });
        int cnt = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            cnt++;
        }
        return intervals.length - cnt;
    }
}
