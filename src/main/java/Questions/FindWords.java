package Questions;

import java.util.ArrayList;
import java.util.List;

public class FindWords {
    /**
     * Lint 194
     *
     * @param str:  the string
     * @param dict: the dictionary
     * @return: return words which  are subsequences of the string
     */
    public static List<String> findWords(String str, List<String> dict) {
        // write your code here.
        if (str == null || str.length() == 0 || dict == null || dict.size() == 0)
            return null;

        List<String> res = new ArrayList<>(dict.size());
        for (String word : dict) {
            if (helper(str, word)) {
                res.add(word);
            }
        }

        return res;
    }

    private static boolean helper(String str, String target) {
        if (target.length() > str.length())
            return false;

        int sIdx = 0, tIdx = 0;
        while (sIdx < str.length()) {
            if (str.charAt(sIdx) == target.charAt(tIdx)) {
                tIdx++;
                if (tIdx == target.length())
                    return true;
            }
            sIdx++;
        }

        return false;
    }
}
