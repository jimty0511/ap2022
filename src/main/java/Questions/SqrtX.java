package Questions;

public class SqrtX {
    /**
     * Lint 141
     *
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if (x == 0)
            return 0;

        int left = 0, right = x;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (right > x / right)
            return left;

        return right;
    }
}
