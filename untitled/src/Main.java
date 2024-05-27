public class Main {

    public static void main(String[] args) {
        int[] testNums = new int[3];
        testNums[0] = 1;
        testNums[1] = 5;
        testNums[2] = 0;
        int ans = P41.Solution41.firstMissingPositive(testNums);
        System.out.println("ans = " + ans);
    }


}