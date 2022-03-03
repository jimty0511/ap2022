package Questions;

public class SearchA2DMatrix {
    /**
     * Lint 28
     *
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int n = matrix.length, m = matrix[0].length;
        int start = 0, end = n * m - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int midValue = matrix[mid / m][mid % m];
            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (matrix[start / m][start % m] == target || matrix[end / m][end % m] == target)
            return true;

        return false;
    }
}
