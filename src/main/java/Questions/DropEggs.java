package Questions;

public class DropEggs {
    /**
     * Lint 254, Leet 1884
     *
     * @param n: An integer
     * @return: The sum of a and b
     */
    public int dropEggs(int n) {
        // write your code here
        long idx = 1;
        while (idx * (idx + 1) / 2 < n)
            idx = idx * 2;

        long start = 1, end = idx;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * (mid + 1) / 2 >= n)
                end = mid;
            else
                start = mid;
        }

        if (start * (start + 1) / 2 >= n)
            return (int) start;

        return (int) end;
    }
}
