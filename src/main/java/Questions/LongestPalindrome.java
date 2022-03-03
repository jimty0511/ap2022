package Questions;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {
    /**
     * Lint 627
     *
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // write your code here
        if (s.isEmpty()) {
            return 0;
        }

        int count = 0;
        Set<Character> characterSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!characterSet.add(c)) {
                characterSet.remove(c);
                count++;
            }
        }

        return characterSet.isEmpty() ? count * 2 : count * 2 + 1;
    }
}
