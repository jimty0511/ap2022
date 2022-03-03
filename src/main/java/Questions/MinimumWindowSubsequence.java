package Questions;

public class MinimumWindowSubsequence {
    /**
     * Lint 857
     *
     * @param S: a string
     * @param T: a string
     * @return: the minimum substring of S
     */
    public String minWindow(String S, String T) {
        // Write your code here
        char[] s = S.toCharArray(), t = T.toCharArray();
        String res = "";
        int sIdx = 0, tIdx = 0, sLen = s.length, tLen = t.length, len = Integer.MAX_VALUE;
        while (sIdx < sLen) {
            if (s[sIdx] == t[tIdx]) {
                tIdx++;
                if (tIdx == tLen) {
                    int end = sIdx + 1;
                    tIdx--;
                    while (tIdx >= 0) {
                        if (s[sIdx] == t[tIdx]) {
                            tIdx--;
                        }

                        sIdx--;
                    }

                    sIdx++;
                    tIdx++;
                    if (end - sIdx < len) {
                        len = end - sIdx;
                        res = S.substring(sIdx, end);
                    }
                }
            }
            sIdx++;
        }

        return res;
    }
}
