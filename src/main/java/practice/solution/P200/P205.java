package practice.solution.P200;

import org.springframework.stereotype.Component;

/**
 * @Author William Wang
 */
@Component
public class P205 {

    public boolean isIsomorphic(String s, String t) {
        //如果s串用了相同的字符，那么t串也应该使用了相同的字符，那他们使用的相同的字符上次出现的位置应该一样。
        int[] lastAppearIndexInS = new int[256];
        int[] lastAppearIndexInT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (lastAppearIndexInS[sc] != lastAppearIndexInT[tc]) {
                return false;
            }
            lastAppearIndexInS[sc] = i + 1;
            lastAppearIndexInT[tc] = i + 1;
        }
        return true;
    }
}

