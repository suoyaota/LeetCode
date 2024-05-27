import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2019/10/8 16:14
 * @Author William Wang
 */
public class P229 {
    class Solution1 {
        /**
         *@Date 2019/10/8 16:39
         *@Author William Wang
         *@Desicription 多数投票算法
         */
        public List<Integer> majorityElement(int[] nums) {
            int candidate1 = 0;
            int candidate2 = 0;
            int count1 = 0;
            int count2 = 0;
            for (int num:nums) {
                if (candidate1 == num) {
                    count1++;
                } else if (candidate2 == num) {
                    count2++;
                } else if (count1 == 0) {
                    candidate1 = num;
                    count1++;
                } else if (count2 == 0) {
                    candidate2 = num;
                    count2++;
                } else {
                    count1--;
                    count2--;
                }
            }
            count1 = 0;
            count2 = 0;
            for (int num:nums) {
                if (num == candidate1) {
                    count1++;
                } else if (num == candidate2) {
                    count2++;
                }
            }
            List<Integer> ans = new ArrayList<>();
            if (count1 > nums.length/3) {
                ans.add(candidate1);
            }
            if (count2 > nums.length/3) {
                ans.add(candidate2);
            }
            return ans;
        }
    }
}
