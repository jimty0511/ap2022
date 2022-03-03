package Questions;

public class RemoveDuplicatesFromSortedArrayII {
    /**
     * Lint 101
     *
     * @param nums: a array of integers
     * @return : return an integer
     */
    public static int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) return 0;

        int left = 0, right = 0, count = 1;
        while (right < nums.length) {
            while (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                right++;
                if (count < 2) {
                    count++;
                }
            }

            while (count > 0 && left <= right) {
                nums[left++] = nums[right];
                count--;
            }

            count = 1;
            right++;
        }

        return left;
    }
}
