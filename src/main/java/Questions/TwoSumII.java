package Questions;

public class TwoSumII {
    /**
     * Lint 608
     *
     * @param nums:   an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        int[] res = new int[2];
        if (nums == null || nums.length == 0)
            return res;

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int curVal = nums[left] + nums[right];
            if (curVal == target) {
                res[0] = left + 1;
                res[2] = right + 1;
                return res;
            } else if (curVal > target) {
                right--;
            } else {
                left++;
            }
        }

        return res;
    }

    public int[] binarySearch(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0)
            return res;

        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            } else if (nums[left] + nums[right] > target) {
                right = moveRight(nums, left, right, target - nums[left]);
            } else {
                left = moveLeft(nums, left, right, target - nums[right]);
            }
        }

        return res;
    }

    private int moveRight(int[] nums, int start, int end, int target) {
        int left = start, right = end;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    private int moveLeft(int[] nums, int start, int end, int target) {
        int left = start, right = end;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
