package Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    /**
     * Lint 58
     *
     * @param numbers: Give an array
     * @param target:  An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // write your code here
        if (numbers == null || numbers.length == 0)
            return null;

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 3; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1])
                continue;

            for (int j = i + 1; j < numbers.length - 2; j++) {
                if (j != i + 1 && numbers[j] == numbers[j - 1])
                    continue;

                int left = j + 1, right = numbers.length - 1;
                while (left < right) {
                    int sum = numbers[i] + numbers[j] + numbers[left] + numbers[right];
                    if (sum == target) {
                        res.add(Arrays.asList(numbers[i], numbers[j], numbers[left], numbers[right]));
                        left++;
                        right--;

                        while (left < right && numbers[left] == numbers[left - 1])
                            left++;
                        while (left < right && numbers[right] == numbers[right + 1])
                            right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return res;
    }

    public List<List<Integer>> fourSumTwo(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0)
            return null;

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(numbers);
        helper(numbers, target, res, new ArrayList<>(), 0);
        return res;
    }

    private void helper(int[] numbers, int target, List<List<Integer>> res, List<Integer> tmp, int idx) {
        if (tmp.size() == 4) {
            if (target == 0) {
                res.add(new ArrayList<>(tmp));
            }
        } else {
            for (int i = idx; i < numbers.length; i++) {
                if (i != idx && numbers[i] == numbers[i - 1])
                    continue;

                tmp.add(numbers[i]);
                helper(numbers, target - numbers[i], res, tmp, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
