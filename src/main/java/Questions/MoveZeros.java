package Questions;

public class MoveZeros {
    /**
     * Lint 539
     *
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0)
            return;

        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0)
                nums[left++] = nums[right];
            right++;
        }

        while (left < nums.length)
            nums[left++] = 0;
    }
}
