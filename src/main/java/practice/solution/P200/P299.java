package practice.solution.P200;

import org.springframework.stereotype.Component;

/**
 * @Date 2019/10/9 18:32
 * @Author William Wang
 */
@Component
public class P299 {

    public String getHint(String secret, String guess) {
        int[] numS = new int[10];
        int[] numG = new int[10];
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else {
                numS[secret.charAt(i) - '0']++;
                numG[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (numS[i] != 0 && numG[i] != 0) {
                cow += Math.min(numS[i], numG[i]);
            }
        }
        String ans = bull + "A" + cow + "B";
        return ans;
    }
}


