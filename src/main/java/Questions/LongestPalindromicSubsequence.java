package Questions;

public class LongestPalindromicSubsequence {
    /**
     * Lint 667
     *
     * @param s: the maximum length of s is 1000
     * @return: the longest palindromic subsequence's length
     */
    public int longestPalindromeSubseq(String s) {
        // write your code here
        if (s == null || s.isEmpty())
            return 0;
        int n = s.length();
        return helper(s, 0, n - 1, new int[n][n]);
    }

    public int helper(String s, int left, int right, int[][] memo) {
        if (memo[left][right] != 0)
            return memo[left][right];

        if (left > right)
            return 0;

        if (left == right)
            return 1;

        if (s.charAt(left) == s.charAt(right)) {
            memo[left][right] = helper(s, left + 1, right - 1, memo) + 2;
        } else {
            memo[left][right] = Math.max(helper(s, left + 1, right, memo), helper(s, left, right - 1, memo));
        }

        return memo[left][right];
    }

    public int dp(String s) {
        if (s == null || s.isEmpty())
            return 0;

        int n = s.length();
        int[][] dp = new int[n][n];
        for (int right = 0; right < n; right++) {
            dp[right][right] = 1;
            for (int left = right - 1; left >= 0; left--) {
                if (s.charAt(left) == s.charAt(right)) {
                    dp[left][right] = dp[left + 1][right - 1] + 2;
                } else {
                    dp[left][right] = Math.max(dp[left + 1][right], dp[left][right - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
