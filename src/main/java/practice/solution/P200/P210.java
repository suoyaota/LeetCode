package practice.solution.P200;

import org.springframework.stereotype.Component;

import java.util.*;


/**
 * @Author William Wang
 */
@Component
public class P210 {

    int[] visited;
    int[] ans;
    int index;
    boolean hasCircle;
    List<List<Integer>> edges;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }
        // 0 未搜索，1搜索中，2搜索完毕
        visited = new int[numCourses];
        ans = new int[numCourses];
        index = numCourses - 1;
        hasCircle = false;
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            List<Integer> list = new ArrayList<>();
            edges.add(list);
        }
        for(int[] req : prerequisites) {
            int pre = req[1];
            int next = req[0];
            edges.get(pre).add(next);
        }
        for (int i = 0; i < numCourses; i++) {
            if (hasCircle) {
                return new int[0];
            }
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return ans;
    }

    private void dfs(Integer node) {
        if (hasCircle) {
            return;
        }
        if (visited[node] == 1) {
            hasCircle = true;
            return;
        }
        if (visited[node] == 2) {
            return;
        }
        visited[node] = 1;
        List<Integer> nextNodeList = edges.get(node);
        for (int nextNode : nextNodeList) {
            dfs(nextNode);
        }
        ans[index] = node;
        index--;
        visited[node] = 2;
        return;
    }


    // 广度优先搜索
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        int ansIdx = 0;
        if (numCourses <= 1) {
            return ans;
        }
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        int[] inDegree = new int[numCourses];
        for (int[] req : prerequisites) {
            List<Integer> list = edges.get(req[1]);
            list.add(req[0]);
            inDegree[req[0]]++;
        }
        // 入度为0的节点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans[ansIdx] = node;
            ansIdx++;
            List<Integer> list = edges.get(node);
            for (int nextNode : list) {
                if (--inDegree[nextNode] == 0) {
                    queue.offer(nextNode);
                }
            }
        }
        if (ansIdx == numCourses) {
            return ans;
        }
        return new int[0];

    }


}
