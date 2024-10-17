package practice.solution;

/**
 * @author wyb
 */
public class P744 {

    public char nextGreatestLetter(char[] letters, char target) {
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] - target > 0) {
                return letters[i];
            }
        }
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] - target + 26 > 0) {
                return letters[i];
            }
        }
        return letters[0];
    }
}
