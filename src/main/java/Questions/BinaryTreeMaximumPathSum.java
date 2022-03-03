package Questions;

import Objects.TreeNode;

public class BinaryTreeMaximumPathSum {
    private int res = Integer.MIN_VALUE;

    /**
     * Lint 94
     *
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null)
            return 0;

        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        int curSum = Math.max(left, right) + root.val;
        res = Math.max(res, Math.max(curSum, left + right + root.val));
        return curSum;
    }
}
