package Questions;

public class FirstBadVersion {
    /**
     * Lint 74
     *
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        if (n == 0)
            return 0;

        int start = 0, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (SVNRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (SVNRepo.isBadVersion(start))
            return start;

        return end;
    }

    public static class SVNRepo {
        public static boolean isBadVersion(int k) {
            return false;
        }
    }
}
