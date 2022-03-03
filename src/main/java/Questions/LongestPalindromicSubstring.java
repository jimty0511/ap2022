package Questions;

public class LongestPalindromicSubstring {
    /**
     * Lint 200
     *
     * @param s: input string
     * @return: a string as the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // write your code here
        if (s == null || s.isEmpty())
            return null;

        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            String odd = helper(s, i, i);
            if (longest.length() < odd.length())
                longest = odd;
            String even = helper(s, i, i + 1);
            if (longest.length() < even.length())
                longest = even;
        }

        return longest;
    }

    public String helper(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right))
                break;

            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }

    public String dp(String s) {
        if (s == null || s.isEmpty())
            return null;

        int n = s.length();
        int longest = 1, start = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (dp[i][i + 1]) {
                longest = 2;
                start = i;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);

                if (dp[i][j] && j - i + 1 > longest) {
                    start = i;
                    longest = j - i + 1;
                }
            }
        }

        return s.substring(start, start + longest);
    }

    public String dpEasy(String s) {
        if (s == null || s.length() == 0)
            return null;

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int longest = 0, start = 0;
        for (int right = 0; right < n; right++) {
            for (int left = right; left >= 0; left--) {
                dp[left][right] = s.charAt(left) == s.charAt(right) && (right - left < 3 || dp[left + 1][right - 1]);
                if (dp[left][right] && longest < right - left + 1) {
                    longest = right - left + 1;
                    start = left;
                }
            }
        }

        return s.substring(start, start + longest);
    }

    public String dpTwo(String s) {
        if (s == null || s.isEmpty())
            return null;

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = "";
        for (int left = n - 1; left >= 0; left--) {
            for (int right = left; right < n; right++) {
                dp[left][right] = s.charAt(left) == s.charAt(right) && (right - left < 2 || dp[left + 1][right - 1]);
                if (dp[left][right] && res.length() < right - left + 1) {
                    res = s.substring(left, right + 1);
                }
            }
        }

        return res;
    }
}
