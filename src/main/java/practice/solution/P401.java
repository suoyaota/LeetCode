package practice.solution;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2019/10/9 18:37
 * @Author William Wang
 */
@Component
public class P401 {

    public List<String> readBinaryWatch(int num) {
        int[] time = new int[65];
        List<String> list = new ArrayList<>();
        String ans;
        for (int i = 0; i < 60; i++) {
            time[i] = toBin(i);
        }
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (time[h] + time[m] == num) {
                    if (m < 10) {
                        ans = h + ":" + "0" + m;
                    } else ans = h + ":" + m;
                    list.add(ans);
                }
            }
        }
        return list;
    }

    public int toBin(int num) {
        int remainder;
        int ans = 0;
        while (num != 0) {
            remainder = num % 2;
            if (remainder == 1) ans++;
            num = num / 2;
        }
        return ans;
    }
}


