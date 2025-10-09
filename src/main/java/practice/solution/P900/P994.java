package practice.solution.P900;

import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @Author WilliamWang
 * @Date 2025/6/11-17:03
 */

@Component
public class P994 {
    int[] dr = new int[]{0, -1, 0, 1};
    int[] dc = new int[]{1, 0, -1, 0};
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        Queue<Integer> rottedBoxOrderQueue = new LinkedList<>();
        Map<Integer, Integer> order2AnsMap = new HashMap<>();
        int orangeNum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    int order = i * n + j;
                    rottedBoxOrderQueue.offer(order);
                    order2AnsMap.put(order, 0);
                }
                if (grid[i][j] == 1) {
                    orangeNum++;
                }
            }
        }
        while (!rottedBoxOrderQueue.isEmpty()) {
            int order = rottedBoxOrderQueue.poll();
            int time = order2AnsMap.get(order);
            for (int i = 0; i < 4; i++) {
                int x = order / n;
                int y = order - x * n;
                x = x + dr[i];
                y = y + dc[i];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                    orangeNum--;
                    grid[x][y] = 2;
                    int newOrder = x * n + y;
                    rottedBoxOrderQueue.offer(newOrder);
                    ans = time + 1;
                    order2AnsMap.put(newOrder, ans);
                }
            }
        }
        return orangeNum == 0 ? ans : -1;
    }
}
