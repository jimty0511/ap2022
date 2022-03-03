package Questions;

public class KthSmallestNumbersInUnsortedArray {
    /**
     * Lint 461
     *
     * @param k:    An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        // return partition(nums, 0, nums.length - 1, k);
        // 数组从0开始标号，要传k - 1
        return partitionTwo(nums, 0, nums.length - 1, k - 1);
    }

    private int partitionTwo(int[] nums, int start, int end, int k) {
        int left = start, right = end, mid = start + (end - start) / 2, pivot = nums[mid];
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }

        if (k <= right) {
            return partitionTwo(nums, start, right, k);
        } else if (k >= left) {
            return partitionTwo(nums, left, end, k);
        }

        return nums[k];
    }

    private int partition(int[] nums, int start, int end, int k) {
        if (start == end)
            return nums[start];

        int left = start, right = end, mid = start + (end - start) / 2, pivot = nums[mid];
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }

        if (start + k - 1 <= right) {
            return partition(nums, start, right, k);
        } else if (start + k - 1 >= left) {
            return partition(nums, left, end, k - (left - start));
        }

        return nums[right + 1];
    }
}
