package practice.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author wyb
 */
public class P406 {

    public int[][] reconstructQueue(int[][] people) {
//            Arrays.sort(people, (p1, p2) -> {
//                if (p1[0] != p2[0]) {
//                    return p2[0] - p1[0];
//                } else {
//                    return p1[1] - p2[1];
//                }
//            });
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2) {
                if (p1[0] != p2[0]) {
                    return p2[0] - p1[0];
                } else {
                    return p1[1] - p2[1];
                }
            }
        });

        // Arrays.sort(people, (p1,p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);

        List<int[]> ans = new ArrayList<>();
        for (int[] p : people) {
            ans.add(p[1], p);
        }
        return ans.toArray(new int[people.length][]);
        //toArray()传入数组的话会拷贝一个内容进这个数组然后返回该数组。
    }
}

