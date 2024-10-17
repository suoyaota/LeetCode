package practice.solution;

import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author William Wang
 * @date 2019/11/13 21:00
 */
@Component
public class P6 {

    /**
     * @Date 2019/11/13 21:00
     * @Author William Wang
     * @Desicription 朴素又愚蠢的取余数做法。
     * Runtime: 24.24% Memory Usage: 45.75%
     */
    public String convert(String s, int numRows) {
        if (s.length() == 0 || numRows == 1) {
            return s;
        }
        int len = s.length();
        int num = (numRows - 2) * 2 + 2;
        int[] numOrder = new int[num];
        numOrder[0] = 1;
        numOrder[num - 1] = numRows;
        int t = 2;
        int p = 0;
        for (int i = 1; i < num - 1; i++) {
            if (i % 2 != 0) {
                numOrder[i] = t;
                t++;
            } else {
                numOrder[i] = (num - p) % num;
                p++;
            }
        }
        System.out.println(Arrays.toString(numOrder));
        char[] ansNum = new char[len];
        int i = 0;
        int a = 0;
        for (; i < num; ) {
            if (i == 0 || i == num - 1) {
                int j = numOrder[i] - 1;
                while (j < len) {
                    ansNum[a] = s.charAt(j);
                    a++;
                    j += num;
                }
                i++;
            } else {
                int m = numOrder[i] - 1;
                int n = numOrder[i + 1] - 1;
                if (n == -1) {
                    n += num;
                }
                while (m < len || n < len) {
                    if (m < len) {
                        ansNum[a] = s.charAt(m);
                        a++;
                        m += num;
                    }

                    if (n < len) {
                        ansNum[a] = s.charAt(n);
                        a++;
                        n += num;
                    }
                }
                i += 2;
            }
        }
        StringBuffer ans = new StringBuffer();
        for (char c : ansNum) {
            ans.append(c);
        }
        return ans.toString();
    }
}

