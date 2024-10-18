package practice.solution;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * @Author William Wang
 */
@Component
public class P210 {

    //深度优先搜索
    int[] visited;//1表示搜索中，2表示搜索完毕
    List<Integer>[] graphic;
    Stack<Integer> stack;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        graphic = new List[numCourses];
        stack = new Stack<Integer>();
        for (int i = 0; i < numCourses; i++) {
            graphic[i] = new ArrayList<Integer>();
        }
        for (int[] pre : prerequisites) {
            graphic[pre[1]].add(pre[0]);//记录每个节点入了谁
        }
        for (int i = 0; i < numCourses; i++) {
            //从任意节点开始深度优先搜索
            if (!dfs(i)) {
                return new int[0];
            }
        }
        int[] ans = new int[numCourses];
        int idx = 0;
        while (!stack.isEmpty()) {
            ans[idx++] = stack.pop();
        }
        return ans;
    }

//    //广度优先搜索
////入度数组，节点入了谁，队列非空判断
//    int[] indegree;
//    List<Integer>[] graphic;
//    Queue<Integer> queue;
//    public int[] findOrder2(int numCourses, int[][] prerequisites) {
//        indegree = new int[numCourses];
//        graphic = new List[numCourses];
//        queue = new LinkedList<Integer>();
//        for (int i = 0; i < numCourses; i++) {
//            graphic[i] = new ArrayList<>();
//        }
//        for (int[] pre : prerequisites) {
//            graphic[pre[1]].add(pre[0]);
//            indegree[pre[0]]++;
//        }
//        for (int i = 0; i < numCourses; i++) {
//            if (indegree[i] == 0) {
//                queue.offer(i);
//            }
//        }
//        int idx = 0;
//        int[] ans = new int[numCourses];
//        while (!queue.isEmpty()) {
//            int course = queue.poll();
//            ans[idx++] = course;
//            for (int nextCourse : graphic[course]) {
//                indegree[nextCourse]--;
//                if (indegree[nextCourse] == 0) {
//                    queue.offer(nextCourse);
//                }
//            }
//        }
//        if (idx == numCourses) {
//            return ans;
//        } else {
//            return new int[0];
//        }
//    }

    private boolean dfs(int course) {
        if (visited[course] == 1) {
            return false;
        }
        if (visited[course] == 2) {
            return true;
        }
        visited[course] = 1;
        for (int nextCourse : graphic[course]) {
            if (!dfs(nextCourse)) {
                return false;
            }
        }
        visited[course] = 2;
        stack.push(course);
        return true;
    }
}
