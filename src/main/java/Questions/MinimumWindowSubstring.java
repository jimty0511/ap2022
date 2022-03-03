package Questions;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    /**
     * Lint 32
     *
     * @param source  : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code here
        if (target.length() > source.length())
            return "";

        Map<Character, Integer> map = new HashMap<>();
        for (char c : target.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int counter = map.size();
        int left = 0, right = 0, start = 0, minLen = Integer.MAX_VALUE;
        while (right < source.length()) {
            char c = source.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0)
                    counter--;
            }

            right++;
            while (counter == 0) {
                char begin = source.charAt(left);
                if (map.containsKey(begin)) {
                    map.put(begin, map.get(begin) + 1);
                    if (map.get(begin) > 0)
                        counter++;
                }
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : source.substring(start, start + minLen);
    }
}
