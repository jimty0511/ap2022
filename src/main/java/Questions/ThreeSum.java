package Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /**
     * Lint 57
     *
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        Arrays.sort(numbers);
        List<List<Integer>> res = new ArrayList<>();
        int n = numbers.length;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1])
                continue;

            int low = i + 1, high = n - 1, sum = 0 - numbers[i];
            while (low < high) {
                if (numbers[low] + numbers[high] == sum) {
                    res.add(Arrays.asList(numbers[i], numbers[low], numbers[high]));
                    while (low < high && numbers[low] == numbers[low + 1])
                        low++;
                    while (low < high && numbers[high] == numbers[high - 1])
                        high--;
                    low++;
                    high--;
                } else if (numbers[low] + numbers[high] < sum) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return res;
    }
}
