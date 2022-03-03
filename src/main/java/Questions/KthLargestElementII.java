package Questions;

public class KthLargestElementII {
    /**
     * Lint 606
     *
     * @param nums: an integer unsorted array
     * @param k:    an integer from 1 to n
     * @return: the kth largest element
     */
    public int kthLargestElement2(int[] nums, int k) {
        // write your code here
        return partition(nums, 0, nums.length - 1, k);
    }

    public int partition(int[] nums, int start, int end, int k) {
        if (start == end)
            return nums[start];

        int left = start, right = end, mid = left + (start - left) / 2, pivot = nums[mid];
        while (left <= right) {
            while (left <= right && nums[left] > pivot)
                left++;
            while (left <= right && nums[right] < pivot)
                right--;
            if (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }

        if (start + k - 1 <= right)
            return partition(nums, start, right, k);
        if (start + k - 1 >= left)
            return partition(nums, left, end, k - (left - start));

        return nums[right + 1];
    }
}
