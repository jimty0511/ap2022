package Questions;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIII {

    Map<Integer, Integer> map = new HashMap<>();

    /**
     * Lint 607
     *
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        // write your code here
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        for (int n : map.keySet()) {
            int diff = value - n;
            if (map.containsKey(diff) && (diff != n || map.get(diff) > 1))
                return true;
        }

        return false;
    }
}
