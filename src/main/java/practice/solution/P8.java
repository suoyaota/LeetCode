package practice.solution;

import org.springframework.stereotype.Component;

/**
 * @Date 2019/10/9 18:18
 * @Author William Wang
 */
@Component
public class P8 {

    public int myAtoi(String str) {
        if (str == null || str == "") {
            return 0;
        }
        char[] input = str.toCharArray();
        String ans = "";
        boolean b = false;
        for (char a : input) {
            if (b == true) {
                if (a >= '0' && a <= '0' + 9) {
                    ans = ans + a;
                    continue;
                } else {
                    break;
                }
            }
            if (a == ' ') {
                continue;
            } else if (a >= '0' && a <= '0' + 9 || a == '+' || a == '-') {
                ans = ans + a;
                b = true;
                continue;
            } else {
                return 0;
            }
        }
        if (ans == "" || ans == "+" || ans == "-") {
            return 0;
        }
        System.out.println(ans);/////////
        char[] num = ans.toCharArray();
        int n = num.length;
        System.out.println(n);///////////
        long ansNum = 0;
        int j = 0;
        if (num[0] == '+') {
            for (int i = n - 1; i >= 1; i--) {
                ansNum += (num[i] - 48) * Math.pow(10, j);
                j++;
                if (ansNum > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }

            }
            return (int) ansNum;
        } else if (num[0] == '-') {
            for (int i = n - 1; i >= 1; i--) {
                ansNum += (num[i] - 48) * Math.pow(10, j);
                j++;
                if (ansNum > Integer.MAX_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
            ansNum = -ansNum;
            return (int) ansNum;
        } else {
            for (int i = n - 1; i >= 0; i--) {
                System.out.println(j);//////
                ansNum += (num[i] - 48) * Math.pow(10, j);
                System.out.println(ansNum);
                j++;
                if (ansNum > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            }
            return (int) ansNum;
        }
    }
}

