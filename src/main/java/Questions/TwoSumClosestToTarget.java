package Questions;

import java.util.Arrays;

public class TwoSumClosestToTarget {
    /**
     * Lint 533
     *
     * @param nums:   an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0)
            return 0;

        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, diff = Integer.MAX_VALUE;
        while (left < right) {
            int vl = nums[left], vr = nums[right];
            if (vr + vl == target)
                return 0;

            diff = Math.min(diff, Math.abs(target - vr - vl));
            if (vl + vr < target) {
                while (left < right && nums[left] == vl)
                    left++;
            } else {
                while (left < right && nums[right] == vr)
                    right--;
            }
        }

        return diff;
    }
}
