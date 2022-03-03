package Questions;

public class SearchForARange {
    /**
     * Lint 61
     *
     * @param A:      an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] res = new int[]{-1, -1};
        if (A == null || A.length == 0)
            return res;

        res[0] = findLowerBound(A, target);
        res[1] = findHigherBound(A, target);
        return res;
    }

    private int findLowerBound(int[] A, int target) {
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                end = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (A[start] == target)
            return start;
        if (A[end] == target)
            return end;

        return -1;
    }

    private int findHigherBound(int[] A, int target) {
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (A[end] == target)
            return end;
        if (A[start] == target)
            return start;

        return -1;
    }
}
