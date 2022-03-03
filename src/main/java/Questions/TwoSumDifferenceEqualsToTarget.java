package Questions;

public class TwoSumDifferenceEqualsToTarget {
    /**
     * Lint 610
     *
     * @param nums:   an array of Integer
     * @param target: an integer
     * @return: [num1, num2] (num1 < num2)
     */
    public int[] twoSum7(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length < 2)
            return res;

        target = Math.abs(target);
        int i = 0, j = 1;
        while (i < j && j < nums.length) {
            int diff = nums[j] - nums[i];
            if (diff == target) {
                res[0] = nums[i];
                res[1] = nums[j];
                return res;
            } else if (diff < target) {
                j++;
            } else {
                i++;
                if (i == j)
                    j++;
            }
        }

        return res;
    }
}
