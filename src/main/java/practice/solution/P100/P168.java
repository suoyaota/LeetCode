package practice.solution.P100;

import org.springframework.stereotype.Component;

/**
 * @Date 2019/10/9 18:26
 * @Author William Wang
 */
@Component
public class P168 {

    public String convertToTitle(int n) {
        char[] a = new char[26];
        for (int i = 0; i < 26; i++) {
            a[i] = (char) ('A' + i);
        }
        n--;
        int sum = 25;
        int i = 1;
        while (n > sum) {
            sum += Math.pow(26, i + 1);
            i++;
        }
        int ii = i;
        while (true) {
            i--;
            if (i == 0) break;
            n -= Math.pow(26, i);
        }
        char[] ans0 = new char[ii];
        int rem = 0;
        while (true) {
            rem = n % 26;
            ii--;
            ans0[ii] = a[rem];
            n = n / 26;
            if (ii == 0) break;
        }
        String ans = String.valueOf(ans0);
        return ans;
    }
}


