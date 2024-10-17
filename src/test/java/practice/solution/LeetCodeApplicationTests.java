package practice.solution;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class LeetCodeApplicationTests {

    @Autowired
    P1 p1;

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

}
