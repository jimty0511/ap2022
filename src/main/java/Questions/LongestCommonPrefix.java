package Questions;

public class LongestCommonPrefix {
    // Leet 14

    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        String first = strs[0], last = strs[strs.length - 1];
        for (String s : strs) {
            if (s.compareTo(first) < 0)
                first = s;
            if (s.compareTo(last) > 0)
                last = s;
        }

        int i = 0, len = Math.min(first.length(), last.length());
        while (i < len && first.charAt(i) == last.charAt(i)) {
            i++;
        }

        return first.substring(0, i);
    }

    public static String longestCommonPrefixTwo(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            minLen = Math.min(minLen, s.length());
        }

        int left = 0, right = minLen;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (helper(strs, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (helper(strs, right))
            return strs[0].substring(0, right);

        return strs[0].substring(0, left);
    }

    private static boolean helper(String[] strs, int mid) {
        String pre = strs[0].substring(0, mid);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(pre))
                return false;
        }

        return true;
    }
}
