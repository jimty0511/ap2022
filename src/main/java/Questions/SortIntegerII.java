package Questions;

public class SortIntegerII {
    /**
     * Lint 464
     *
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        if (A == null || A.length == 0)
            return;

        // quickSort(A, 0, A.length - 1);
        int[] tmp = new int[A.length];
        mergeSort(A, 0, A.length - 1, tmp);
    }

    public void quickSort(int[] A, int start, int end) {
        if (start >= end)
            return;

        int left = start, right = end, mid = start + (end - start) / 2;
        int pivot = A[mid];
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int tmp = A[left];
                A[left] = A[right];
                A[right] = tmp;
                left++;
                right--;
            }
        }

        quickSort(A, left, end);
        quickSort(A, start, right);
    }

    public void mergeSort(int[] A, int start, int end, int[] tmp) {
        if (start >= end)
            return;

        int mid = start + (end - start) / 2;
        mergeSort(A, start, mid, tmp);
        mergeSort(A, mid + 1, end, tmp);
        merge(A, start, end, tmp);
    }

    public void merge(int[] A, int start, int end, int[] tmp) {
        int leftStart = start, mid = start + (end - start) / 2, rightStart = mid + 1, idx = start;
        while (leftStart <= mid && rightStart <= end) {
            if (A[leftStart] <= A[rightStart]) {
                tmp[idx++] = A[leftStart++];
            } else {
                tmp[idx++] = A[rightStart++];
            }
        }

        while (leftStart <= mid) {
            tmp[idx++] = A[leftStart++];
        }

        while (rightStart <= end) {
            tmp[idx++] = A[rightStart++];
        }

        for (int i = start; i <= end; i++) {
            A[i] = tmp[i];
        }
    }
}
