import java.util.ArrayList;
import java.util.List;

/**
 * @author wyb
 */
public class P207 {
    class Solution1 {
        //深度优先搜索
        int[] visited;
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            //检测有向图是否存在环
            visited = new int[numCourses];
            //默认值是0,1表示搜索中，2表示搜索完成

            List<Integer>[] graphic = new List[numCourses];
            for(int i = 0; i < numCourses; i++) {
                graphic[i] = new ArrayList<Integer>();
            }
            for (int[] pre : prerequisites) {
                graphic[pre[1]].add(pre[0]);
            }
            for (int course = 0; course < numCourses; course++) {
                if(visited[course] == 0 && hasCycle(graphic,course)) {
                    return false;
                }
            }
            return true;
        }

        private boolean hasCycle(List<Integer>[] graphic , int course) {
            if (visited[course] == 1) {
                //搜索中，有环
                return true;
            }
            if (visited[course] == 2) {
                //搜索过，无环
                return false;
            }
            visited[course] = 1;//当前结点搜索中等待返回
            for (int nextCourse : graphic[course]) {
                if (hasCycle(graphic,nextCourse)) {
                    return true;
                }
            }
            visited[course] = 2;
            return false;
        }
    }
}
