package Questions;

import java.util.Arrays;

public class TwoSumGreaterThanTarget {
    /**
     * Lint 443
     *
     * @param nums:   An array of integer
     * @param target: An integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0)
            return 0;

        int n = nums.length;
        Arrays.sort(nums);
        int res = 0, l = 0, r = n - 1;
        while (l < r) {
            if (nums[l] + nums[r] <= target) {
                l++;
            } else {
                res += r - l;
                r--;
            }
        }

        return res;
    }
}
