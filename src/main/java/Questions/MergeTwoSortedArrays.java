package Questions;

public class MergeTwoSortedArrays {
    /**
     * Lint 6
     *
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        if (A == null || A.length == 0)
            return B;

        if (B == null || B.length == 0)
            return A;

        int[] res = new int[A.length + B.length];
        int idx = 0, aIdx = 0, bIdx = 0;
        while (aIdx < A.length && bIdx < B.length) {
            if (A[aIdx] < B[bIdx]) {
                res[idx++] = A[aIdx++];
            } else {
                res[idx++] = B[bIdx++];
            }
        }

        while (aIdx < A.length)
            res[idx++] = A[aIdx++];

        while (bIdx < B.length)
            res[idx++] = B[bIdx++];

        return res;
    }
}
