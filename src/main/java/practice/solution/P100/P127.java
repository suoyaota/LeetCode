package practice.solution.P100;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author William Wang
 */
@Component
public class P127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int n = wordList.size();
        int start = n - 1;
        int end = 0;
        while (end < n) {
            if (wordList.get(end).equals(endWord)) {
                break;
            }
            end++;
        }
        if (end == n) {
            return 0;
        }
        List<Integer>[] graphic = generateGraphic(wordList);
        return getShortestPath(graphic, start, end);

    }

    private List<Integer>[] generateGraphic(List<String> wordList) {
        int n = wordList.size();
        List<Integer>[] graphic = new List[n];
        for (int i = 0; i < n; i++) {
            graphic[i] = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                if (isConnected(wordList.get(i), wordList.get(j))) {
                    graphic[i].add(j);
                }
            }
        }
        return graphic;

    }

    private boolean isConnected(String a, String b) {
        int diffCnt = 0;
        int i = 0;
        while (i < a.length()) {
            if (a.charAt(i) != b.charAt(i)) {
                diffCnt++;
                if (diffCnt == 2) {
                    return false;
                }
            }
            i++;
        }
        return diffCnt == 1;
    }

    private int getShortestPath(List<Integer>[] graphic, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graphic.length];
        queue.add(start);
        int ans = 0;
        visited[start] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            while (size-- > 0) {
                int cur = queue.poll();
                if (cur == end) {
                    return ans;
                }
                visited[cur] = true;
                for (int next : graphic[cur]) {
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
        }
        return 0;
    }
}

