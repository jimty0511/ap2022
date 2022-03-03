package Questions;

public class FindKClosestElements {
    /**
     * Lint 460 二分
     *
     * @param A:      an integer array
     * @param target: An integer
     * @param k:      An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here
        int[] res = new int[k];
        if (A == null || A.length == 0)
            return res;

        // 找到 A[left] < target, A[right] >= target
        // 也就是最接近 target 的两个数，他们肯定是相邻的
        int right = findFirstTarget(A, target);
        int left = right - 1;
        for (int i = 0; i < k; i++) {
            if (isLeftCloser(A, target, left, right)) {
                res[i] = A[left--];
            } else {
                res[i] = A[right++];
            }
        }

        return res;
    }

    public int findFirstTarget(int[] A, int target) {
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

        if (A[start] >= target)
            return start;
        if (A[end] >= target)
            return end;

        return A.length;
    }

    private boolean isLeftCloser(int[] A, int target, int left, int right) {
        if (left < 0)
            return false;
        if (right >= A.length)
            return true;

        return Math.abs(target - A[left]) <= Math.abs(target - A[right]);
    }
}
