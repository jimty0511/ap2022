package Questions;

public class PartitionArrayII {
    /**
     * Lint 625
     *
     * @param nums: an integer array
     * @param low:  An integer
     * @param high: An integer
     * @return: nothing
     */
    public static void partition2(int[] nums, int low, int high) {
        // write your code here
        int left = 0, right = nums.length - 1, idx = 0;
        while (idx <= right) {
            if (nums[idx] < low) {
                swap(nums, idx++, left++);
            } else if (nums[idx] > high) {
                swap(nums, idx, right--);
            } else {
                idx++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
