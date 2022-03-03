package Questions;

public class LongestCommonSubsequence {
    // Leet 1143
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0)
            return 0;

        int[][] memo = new int[text1.length()][text2.length()];
        return helper(memo, text1, text2, 0, 0);
    }

    private int helper(int[][] memo, String text1, String text2, int i, int j) {
        if (i == text1.length() || j == text2.length())
            return 0;

        if (memo[i][j] != 0)
            return memo[i][j];

        if (text1.charAt(i) == text2.charAt(j)) {
            return memo[i][j] = 1 + helper(memo, text1, text2, i + 1, j + 1);
        } else {
            return memo[i][j] = Math.max(helper(memo, text1, text2, i + 1, j), helper(memo, text1, text2, i, j + 1));
        }
    }

    public int longestCommonSubsequenceTwo(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0)
            return 0;

        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }
}
