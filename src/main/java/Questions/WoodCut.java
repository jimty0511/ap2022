package Questions;

public class WoodCut {
    /**
     * Lint 183 二分
     *
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0)
            return 0;

        int maxLen = Integer.MIN_VALUE;
        for (int l : L) {
            maxLen = Math.max(maxLen, l);
        }

        int left = 0, right = maxLen;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (checkDoable(L, k, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (checkDoable(L, k, right))
            return right;

        return left;
    }

    private boolean checkDoable(int[] L, int k, int mid) {
        int cnt = 0;
        for (int l : L) {
            cnt += l / mid;
        }

        return cnt >= k;
    }
}
