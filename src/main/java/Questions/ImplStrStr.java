package Questions;

public class ImplStrStr {
    /**
     * Lint 13
     * @param source:
     * @param target:
     * @return: return the index
     */
    public static int strStr(String source, String target) {
        // Write your code here
        if (target.isEmpty()) {
            return 0;
        }

        for (int i = 0; i <= source.length() - target.length(); i++) {
            for (int j = 0; j < target.length() && source.charAt(i + j) == target.charAt(j); j++) {
                if (j == target.length() - 1) {
                    return i;
                }
            }
        }

        return -1;
    }
}
