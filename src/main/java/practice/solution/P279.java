package practice.solution;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wyb
 */
@Component
public class P279 {

    public int numSquares(int n) {
        List<Integer> squares = generateSquares(n);
        //定义备忘录
        boolean[] visited = new boolean[n + 1];
        //定义队列，添加起点
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            while (size-- > 0) {
                int cur = queue.poll();
                // if (cur == 0) {
                //     return ans;
                // }
                for (int s : squares) {
                    int next = cur - s;
                    if (next < 0) {
                        break;
                    }
                    if (next == 0) {
                        return ans;
                    }
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
        }
        return n;

    }

    private List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }
}

