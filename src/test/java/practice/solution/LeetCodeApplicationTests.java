package practice.solution;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import practice.solution.P0.P25;
import practice.solution.P0.P51;
import practice.solution.P100.P146;
import practice.solution.P200.P215;
import practice.solution.P300.P394;
import practice.solution.P900.P994;
import practice.solution.common.LRUCache;
import practice.solution.common.ListNode;

@SpringBootTest
class LeetCodeApplicationTests {

    @Resource
    P25 p25;
    @Resource
    P146 p146;
    @Resource
    P994 p994;
    @Resource
    P51 p51;
    @Resource
    P394 p394;
    @Resource
    P215 p215;


    @Test
    void contextLoads() {
    }

    @Test
    void testP2() {

    }
    @Test
    void testP25() {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p25.reverseKGroup(p1, 2);
    }

    @Test
    void test146() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        int value1 = lruCache.get(1);
        lruCache.put(3, 3);
        int value2 = lruCache.get(2);
    }
    @Test
    void test994() {
        int[][] testIn = new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        int ans = p994.orangesRotting(testIn);
    }

    @Test
    void testP51() {
        p51.solveNQueens(4);
    }

    @Test
    void testP394() {
        p394.decodeString("3[a]2[bc]");
    }

    @Test
    void testP215() {
        int[] nums = new int[] {3,2,3,1,2,4,5,5,6};
        p215.findKthLargest4(nums, 4);
    }

}
