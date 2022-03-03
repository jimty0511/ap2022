package Questions;

public class ContainerWithMostWater {
    /**
     * Lint 383
     *
     * @param heights: a vector of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        int max = 0, left = 0, right = heights.length - 1;
        while (left < right) {
            int curArea = Math.min(heights[left], heights[right]) * (right - left);
            max = Math.max(max, curArea);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
