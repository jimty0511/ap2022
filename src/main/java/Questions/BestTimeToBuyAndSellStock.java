package Questions;

public class BestTimeToBuyAndSellStock {
    /**
     * Lint 149
     *
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0)
            return 0;

        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }

        return max;
    }

    public int maxProfitTwo(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0)
            return 0;

        int[][] dp = new int[2][prices.length];
        dp[0][0] = -prices[0]; // buy
        dp[1][0] = 0; // sell
        for (int i = 1; i < prices.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], -prices[i]);
            dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] + prices[i]);
        }

        return dp[1][prices.length - 1];
    }
}
