package Questions;

import Objects.TreeNode;

public class TwoSumIV {
    /**
     * Lint 689
     *
     * @param : the root of tree
     * @param : the target sum
     * @return: two numbers from tree which sum is n
     **/
    public int[] twoSum(TreeNode root, int n) {
        // write your code here
        if (root == null)
            return null;

        TreeNode left = minNode(root);
        TreeNode right = maxNode(root);
        while (left != right) {
            if (left.val + right.val == n) {
                return new int[]{left.val, right.val};
            } else if (left.val + right.val < n) {
                left = inorderSuccessor(root, left);
            } else {
                right = inorderPredecessor(root, right);
            }
        }

        return null;
    }

    private TreeNode minNode(TreeNode root) {
        while (root.left != null)
            root = root.left;

        return root;
    }

    private TreeNode maxNode(TreeNode root) {
        while (root.right != null)
            root = root.right;

        return root;
    }

    private TreeNode inorderSuccessor(TreeNode root, TreeNode target) {
        TreeNode succ = null;
        while (root != null) {
            if (target.val < root.val) {
                succ = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return succ;
    }

    private TreeNode inorderPredecessor(TreeNode root, TreeNode target) {
        TreeNode pre = null;
        while (root != null) {
            if (target.val <= root.val) {
                root = root.left;
            } else {
                if (pre == null || root.val > pre.val)
                    pre = root;

                root = root.right;
            }
        }

        return pre;
    }
}
