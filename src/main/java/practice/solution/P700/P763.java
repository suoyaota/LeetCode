package practice.solution.P700;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author William Wang
 */
public class P763 {

    public List<Integer> partitionLabels(String S) {

        int[] lastIdxOfChar = new int[26];

        for (int i = 0; i < S.length(); i++) {
            lastIdxOfChar[char2Index(S.charAt(i))] = i;
        }

        List<Integer> ans = new ArrayList<>();

        int startIdx = 0;
        int lastIdx = 0;

        while (startIdx < S.length()) {
            lastIdx = lastIdxOfChar[char2Index(S.charAt(startIdx))];
            for (int i = startIdx + 1; i < lastIdx; i++) {
                int idx = lastIdxOfChar[char2Index(S.charAt(i))];
                lastIdx = Math.max(idx, lastIdx);
            }
            ans.add(lastIdx - startIdx + 1);
            startIdx = lastIdx + 1;
        }
        return ans;

    }

    private int char2Index(char c) {
        return c - 'a';
    }
}
