package Questions;

public class MaximumNumberInMountainSequence {
    /**
     * Lint 585 二分
     *
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public static int mountainSequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0)
            return -1;

        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return Math.max(nums[start], nums[end]);
    }
}
