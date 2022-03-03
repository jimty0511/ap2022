package Questions;

public class SortColors {
    /**
     * Lint 148
     *
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        int left = 0, right = nums.length - 1, idx = 0;
        while (idx < nums.length) {
            if (nums[idx] == 0 && idx > left) {
                nums[idx] = nums[left];
                nums[left] = 0;
                left++;
            } else if (nums[idx] == 2 && idx < right) {
                nums[idx] = nums[right];
                nums[right] = 2;
                right--;
            } else {
                idx++;
            }
        }
    }
}
