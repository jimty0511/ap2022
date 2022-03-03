package Questions;

import java.util.Arrays;

public class ThreeSumSmaller {
    /**
     * Lint 918
     *
     * @param nums:   an array of n integers
     * @param target: a target
     * @return: the number of index triplets satisfy the condition nums[i] + nums[j] + nums[k] < target
     */
    public int threeSumSmaller(int[] nums, int target) {
        // Write your code here
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                if (nums[low] + nums[high] + nums[i] < target) {
                    res += high - low;
                    low++;
                } else {
                    high--;
                }
            }
        }

        return res;
    }
}
