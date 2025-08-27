package practice.solution.P700;

import java.util.Arrays;

/**
 * @Author William Wang
 */
public class P785 {

    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);//用.
        // 一个数组保存节点颜色，未染色置位-1
        for (int i = 0; i < graph.length; i++) {
            //无向图可能是不连通的，需对每一部分进行判断。
            if (color[i] == -1 && !isBipartite(graph, i, 0, color)) {
                //==-1判断 该部分未被检查过（与之前判断过的部分不连通，因此需要继续判断）
                return false;
            }
        }
        return true;
    }

    private boolean isBipartite(int[][] graph, int curNode, int expectedColor, int[] color) {
        if (color[curNode] != -1) {
            //已经染过色，判断是否符合预期
            return color[curNode] == expectedColor;
        }
        //没染过色，染上正确颜色
        color[curNode] = expectedColor;
        //对连接的结点尝试染色
        for (int node : graph[curNode]) {
            if (!isBipartite(graph, node, 1 - expectedColor, color)) {
                return false;
            }
        }
        return true;
    }
}

