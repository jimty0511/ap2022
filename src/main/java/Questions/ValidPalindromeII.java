package Questions;

import javafx.util.Pair;

public class ValidPalindromeII {
    /**
     * Lint 891
     *
     * @param s: a string
     * @return: whether you can make s a palindrome by deleting at most one character
     */
    public boolean validPalindrome(String s) {
        // Write your code here
        if (s == null || s.length() == 0)
            return false;

        Pair<Integer, Integer> pair = findDifference(s, 0, s.length() - 1);
        if (pair.getKey() >= pair.getValue())
            return true;

        return isPalindrome(s, pair.getKey() + 1, pair.getValue()) || isPalindrome(s, pair.getKey(), pair.getValue() - 1);
    }

    private Pair<Integer, Integer> findDifference(String s, int left, int right) {
        while (left <= right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }

        return new Pair(left, right);
    }

    private boolean isPalindrome(String s, int left, int right) {
        Pair<Integer, Integer> pair = findDifference(s, left, right);
        return pair.getKey() >= pair.getValue();
    }
}
