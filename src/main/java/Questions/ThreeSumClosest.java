package Questions;

import java.util.Arrays;

public class ThreeSumClosest {
    /**
     * Lint 59
     *
     * @param numbers: Give an array numbers of n integer
     * @param target:  An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        if (numbers == null || numbers.length < 3)
            return -1;

        Arrays.sort(numbers);
        int closest = numbers[0] + numbers[1] + numbers[2];
        for (int i = 0; i < numbers.length - 1; i++) {
            int low = i + 1, high = numbers.length - 1;
            while (low < high) {
                int curSum = numbers[i] + numbers[low] + numbers[high];
                if (curSum == target)
                    return target;
                else if (curSum < target) {
                    while (low < high && numbers[i] + numbers[low] + numbers[high] < target) {
                        low++;
                    }
                    if (Math.abs(numbers[i] + numbers[low - 1] + numbers[high] - target) < Math.abs(closest - target))
                        closest = numbers[i] + numbers[low - 1] + numbers[high];
                } else {
                    while (low < high && numbers[i] + numbers[low] + numbers[high + 1] > target) {
                        high--;
                    }
                    if (Math.abs(numbers[i] + numbers[low] + numbers[high + 1] - target) < Math.abs(closest - target))
                        closest = numbers[i] + numbers[low] + numbers[high + 1];
                }
            }
        }

        return closest;
    }
}
