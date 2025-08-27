package practice.solution.P0;

import org.springframework.stereotype.Component;

/**
 * @Author William Wang
 * @Date 2019/11/27 20:22
 */
@Component
public class P9 {

    public boolean isPalindrome(int x) {
        //取数字右半部分并倒置与剩下的数字比较
        if (x == 0) {
            //没这个if会被第二个if判断为false
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            //取右边的方法导致不能是10的倍数
            return false;
        }
        int right = 0;
        while (x > right) {
            right = right * 10 + x % 10;
            x /= 10;
        }
        return x == right || x == right / 10;
    }
}

