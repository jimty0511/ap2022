package Questions;

import java.util.Arrays;

public class MaximumLengthOfRepeatedSubarray {
    private int max = 0;

    // Leet 718
    public int findLength(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return 0;

        int[][] memo = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            Arrays.fill(memo[i], -1);
        }

        helper(nums1, nums2, memo, 0, 0);
        return max;
    }

    private int helper(int[] nums1, int[] nums2, int[][] memo, int i, int j) {
        if (i >= nums1.length || j >= nums2.length)
            return 0;

        if (memo[i][j] != -1)
            return memo[i][j];

        int length = 0;
        if (nums1[i] == nums2[j]) {
            length = helper(nums1, nums2, memo, i + 1, j + 1) + 1;
        }

        int cnt2 = helper(nums1, nums2, memo, i + 1, j);
        int cnt3 = helper(nums1, nums2, memo, i, j + 1);
        max = Math.max(max, Math.max(length, Math.max(cnt2, cnt3)));
        return memo[i][j] = length;
    }
}
