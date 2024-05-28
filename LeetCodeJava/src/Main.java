import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        int[] testNums = new int[3];
//        testNums[0] = 1;

        
//        testNums[1] = 5;
//        testNums[2] = 0;
//        int ans = P41.Solution41.firstMissingPositive(testNums);
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        P88.Solution3.merge(nums1, 3, nums2, 3);

        System.out.println("nums1 = " + Arrays.toString(nums1));

        String[] names = {"ABC", "XYZ", "zoo"};
        String s = names[1];
        names[1] = "cat";
        System.out.println(s); // s是"XYZ"还是"cat"?
    }


}