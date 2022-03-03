package Questions;

public class ImplStrStrII {
    private int BASE = 100007;

    /**
     * Lint 594
     *
     * @param source: A source string
     * @param target: A target string
     * @return: An integer as index
     **/
    public int strStr2(String source, String target) {
        // write your code here
        if (source == null || target == null)
            return -1;

        if (target.length() == 0)
            return 0;

        int m = target.length();
        int power = 1;
        for (int i = 0; i < m; i++) {
            power = (power * 31) % BASE;
        }

        int targetHash = 0;
        for (int i = 0; i < m; i++) {
            targetHash = (targetHash * 31 + target.charAt(i)) % BASE;
        }

        int sourceHash = 0;
        for (int i = 0; i < source.length(); i++) {
            sourceHash = (sourceHash * 31 + source.charAt(i)) % BASE;
            if (i < m - 1)
                continue;

            if (i >= m) {
                sourceHash = sourceHash - (power * source.charAt(i - m)) % BASE;
                if (sourceHash < 0)
                    sourceHash += BASE;
            }

            if (sourceHash == targetHash)
                return i - m + 1;
        }

        return -1;
    }
}
