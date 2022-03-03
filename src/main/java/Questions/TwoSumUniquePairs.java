package Questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumUniquePairs {
    /**
     * Lint 587
     *
     * @param nums:   an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here
        if (nums == null | nums.length < 2)
            return 0;

        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int key : map.keySet()) {
            int diff = target - key;
            if ((diff == key && map.get(diff) > 1 || (diff != key && map.containsKey(diff) && key < diff)))
                cnt++;
        }

        return cnt;
    }

    public int two(int[] nums, int target) {
        if (nums == null | nums.length < 2)
            return 0;

        Arrays.sort(nums);
        int l = 0, r = nums.length - 1, cnt = 0;
        while (l < r) {
            if (nums[l] + nums[r] == target) {
                cnt++;
                l++;
                r--;
                while (l < r && nums[l] == nums[l - 1])
                    l++;
                while (l < r && nums[r] == nums[r + 1])
                    r--;
            } else if (nums[l] + nums[r] > target)
                r--;
            else
                l++;
        }

        return cnt;
    }
}
