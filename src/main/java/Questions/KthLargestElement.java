package Questions;

public class KthLargestElement {
    /**
     * Lint 5
     *
     * @param k:    An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        int n = nums.length;
        k = n - k; // kth smallest
        return partition(nums, k, 0, n - 1);
    }

    private int partition(int[] nums, int k, int start, int end) {
        int left = start, right = end, pivot = nums[(start + end) / 2];
        while (left <= right) {
            while (left <= right && nums[left] < pivot)
                left++;
            while (left <= right && nums[right] > pivot)
                right--;

            if (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }

        if (k >= left) {
            return partition(nums, k, left, end);
        }
        if (k <= right) {
            return partition(nums, k, start, right);
        }

        return nums[k];
    }

    private int partitionTwo(int[] nums, int k, int start, int end) {
        if (start == end)
            return nums[k];

        int left = start, right = end, pivot = nums[(start + end) / 2];
        while (left <= right) {
            while (left <= right && nums[left] < pivot)
                left++;
            while (left <= right && nums[right] > pivot)
                right--;

            if (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }

        if (k <= right) {
            return partition(nums, k, start, right);
        }

        return partition(nums, k, left, end);
    }

    // in video
    public int descendingPartition(int[] nums, int start, int end, int k) {
        if (start == end)
            return nums[start];

        int left = start, right = end, pivot = nums[(start + end) / 2];
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
            return descendingPartition(nums, start, right, k);
        if (start + k - 1 >= left)
            return descendingPartition(nums, left, end, k - (left - start));

        return nums[right + 1];
    }
}
