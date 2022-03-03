package Questions;

import java.util.ArrayList;
import java.util.List;

public class SearchInABigSortedArray {
    /**
     * Lint 447
     *
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return: An integer which is the first index of target.
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        int kth = 1;
        while (reader.get(kth - 1) < target) {
            kth *= 2;
        }

        int start = 0, end = kth - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (reader.get(start) == target)
            return start;

        if (reader.get(end) == target)
            return end;

        return -1;
    }

    public class ArrayReader {
        List<Integer> nums;

        public ArrayReader() {
            nums = new ArrayList<>();
        }

        public int get(int idx) {
            return nums.get(idx);
        }
    }
}
