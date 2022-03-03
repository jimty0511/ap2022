package Questions;

public class InterleavingPositiveAndNegativeNumbers {
    /**
     * Lint 144
     *
     * @param A: An integer array.
     * @return: nothing
     **/
    public void rerange(int[] A) {
        // write your code here
        if (A == null || A.length < 3) return;

        int n = A.length;
        int left = 0, right = n - 1;
        while (left < right) {
            if (A[left] < 0) {
                left++;
                continue;
            }
            if (A[right] > 0) {
                right--;
                continue;
            }
            int tmp = A[left];
            A[left] = A[right];
            A[right] = tmp;
            left++;
            right--;
        }

        if (left > n - left) {
            swap(A, 1, n - 1);
        } else if (left < n - left) {
            swap(A, 0, n - 2);
        } else {
            swap(A, 0, n - 1);
        }
    }

    public void swap(int[] A, int l, int r) {
        while (l < r) {
            int tmp = A[l];
            A[l] = A[r];
            A[r] = tmp;
            l += 2;
            r -= 2;
        }
    }
}
