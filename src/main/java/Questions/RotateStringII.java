package Questions;

public class RotateStringII {
    /**
     * Lint 1790
     *
     * @param str:   An array of char
     * @param left:  a left offset
     * @param right: a right offset
     * @return: return a rotate string
     */
    public String RotateString2(String str, int left, int right) {
        // write your code here
        if (str == null || str.isEmpty())
            return str;

        int len = str.length();
        int offset = left - right;
        boolean flag = offset >= 0 ? true : false;
        offset = Math.abs(offset) % len;
        String A = null, B = null;
        if (flag) {
            A = str.substring(0, offset);
            B = str.substring(offset);
        } else {
            A = str.substring(0, len - offset);
            B = str.substring(len - offset);
        }

        return B.concat(A);
    }
}
