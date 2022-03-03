package Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumVII {
    /**
     * Lint 1978
     *
     * @param nums:   the input array
     * @param target: the target number
     * @return: return the target pair
     */
    public List<List<Integer>> twoSumVII(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 2)
            return null;

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int maxIdx = 0, minIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        int start = minIdx, end = maxIdx;
        while (nums[start] < nums[end]) {
            if (nums[start] + nums[end] == target) {
                res.add(Arrays.asList(Math.min(start, end), Math.max(start, end)));
                start = nextBigger(nums, start);
                end = nextSmaller(nums, end);
            } else if (nums[start] + nums[end] > target) {
                end = nextSmaller(nums, end);
            } else {
                start = nextBigger(nums, start);
            }
        }

        return res;
    }

    private int nextSmaller(int[] nums, int idx) {
        if (nums[idx] <= 0) {
            while (idx < nums.length - 1) {
                idx++;
                if (nums[idx] < 0)
                    return idx;
            }
        } else {
            while (idx > 0) {
                idx--;
                if (nums[idx] >= 0)
                    return idx;
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0)
                    return i;
            }
        }

        return idx;
    }

    private int nextBigger(int[] nums, int idx) {
        if (nums[idx] >= 0) {
            while (idx < nums.length - 1) {
                idx++;
                if (nums[idx] > 0)
                    return idx;
            }
        } else {
            while (idx > 0) {
                idx--;
                if (nums[idx] <= 0)
                    return idx;
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0)
                    return i;
            }
        }

        return idx;
    }
}
