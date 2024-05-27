/**
 * @author William Wang
 * @date 2019/11/6 8:45
 */
public class P28 {
    class Solution1 {
        /**
         *@Date 2019/11/6 8:45
         *@Author William Wang
         *@Desicription 字符串匹配，朴素算法
         *              Runtime: 28.43% Memory Usage: 100%
         */
        public int strStr(String haystack, String needle) {
            for (int i = 0; ; i++) {
                for (int j = 0; ;j++) {
                    if (j == needle.length()) {
                        return i;
                    }
                    if (j + i == haystack.length()) {
                        return -1;
                    }
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                }
            }
        }
    }
}
