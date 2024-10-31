package practice.solution;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class LeetCodeApplicationTests {

    @Autowired
    P1 p1;
    @Resource
    P42 p42;

    @Test
    void contextLoads() {
    }

    @Test
    void testP1() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ans = p1.twoSum(nums, target);
        System.out.println(Arrays.toString(ans));
    }
    @Test
    void testP42() {
        int[] in = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int ans = p42.trap(in);
        System.out.println("ans = " + ans);
    }

}
