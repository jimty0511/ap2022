package Questions;

import java.util.Arrays;

public class TwoSumLessThanOrEqualToTarget {
    /**
     * Lint 609
     *
     * @param nums:   an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum5(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0)
            return 0;

        int n = nums.length;
        Arrays.sort(nums);
        int res = 0, l = 0, r = n - 1;
        while (l < r) {
            int vl = nums[l], vr = nums[r];
            if (nums[l] + nums[r] <= target) {
                res += r - l;
                l++;
            } else {
                while (l < r && nums[r] == vr)
                    r--;
            }
        }

        return res;
    }
}
