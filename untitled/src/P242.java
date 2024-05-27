/**
 * @author wyb
 */
public class P242 {
    class Solution {
        public boolean isAnagram(String s, String t) {
            int[] check = new int[26];
            for (char c : s.toCharArray()) {
                check[c - 'a']++;
            }
            for (char c : t.toCharArray()) {
                check[c - 'a']--;
            }
            for (int num : check) {
                if (num != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
