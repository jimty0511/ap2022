package Questions;

public class MergeSortedArray {
    /**
     * Lint 64
     *
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        if (A == null || A.length == 0 || B == null || B.length == 0)
            return;

        int idx = m + n - 1, aIdx = m - 1, bIdx = n - 1;
        while (aIdx >= 0 && bIdx >= 0) {
            if (A[aIdx] > B[bIdx]) {
                A[idx--] = A[aIdx--];
            } else {
                A[idx--] = B[bIdx--];
            }
        }

        while (aIdx >= 0) {
            A[idx--] = A[aIdx--];
        }

        while (bIdx >= 0) {
            A[idx--] = B[bIdx--];
        }
    }

    public static void mergeSortedArrayTwo(int[] A, int m, int[] B, int n) {
        // write your code here
        if (A == null || A.length == 0 || B == null || B.length == 0)
            return;

        int[] res = new int[m + n];
        int idx = 0, aIdx = 0, bIdx = 0;
        while (aIdx < A.length && bIdx < B.length) {
            if (A[aIdx] <= B[bIdx]) {
                res[idx++] = A[aIdx++];
            } else {
                res[idx++] = B[bIdx++];
            }
        }

        while (aIdx < A.length)
            res[idx++] = A[aIdx++];

        while (bIdx < B.length)
            res[idx++] = B[bIdx++];
    }
}
