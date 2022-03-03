package Questions;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class LongestIncreasingSubsequence {
    /**
     * Lint 76
     *
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0)
            return 0;

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int longest = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                longest = Math.max(longest, dp[i]);
            }
        }

        return longest;
    }

    public int longestIncreasingSubsequenceTwo(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0)
            return 0;

        TreeSet<Integer> set = new TreeSet<>();
        for (int n : nums) {
            Integer ceil = set.ceiling(n);
            if (ceil != null) {
                set.remove(ceil);
            }
            set.add(n);
        }

        return set.size();
    }

    public static int longestIncreasingSubsequenceThree(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n + 1];
        // initialization
        dp[0] = Integer.MIN_VALUE; // 无意义，设为最小不影响计算
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // function
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int len = firstGreaterThanOrEqual(dp, nums[i - 1]);
            dp[len] = nums[i - 1];
            max = Math.max(max, len);
        }

        return max;
    }

    private static int firstGreaterThanOrEqual(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums[left] >= target) {
            return left;
        }
        return right;
    }
}
