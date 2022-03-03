package Questions;

import java.util.Arrays;

public class TriangleCount {
    /**
     * Lint 382
     *
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        // write your code here
        if (S == null || S.length < 3)
            return 0;

        Arrays.sort(S);
        int res = 0;
        for (int i = S.length - 1; i >= 2; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (S[left] + S[right] > S[i]) {
                    res += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }

        return res;
    }
}
