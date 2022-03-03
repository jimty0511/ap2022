package Questions;

import Objects.TreeNode;

import java.util.Stack;

public class InorderPredecessorInBST {
    /**
     * @param root: the given BST
     * @param p:    the given node
     * @return: the in-order predecessor of the given node in the BST
     */
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        // write your code here
        TreeNode pre = null;
        while (root != null) {
            if (p.val <= root.val) {
                root = root.left;
            } else {
                if (pre == null || root.val > pre.val)
                    pre = root;

                root = root.right;
            }
        }

        return pre;
    }

    public TreeNode stk(TreeNode root, TreeNode p) {
        TreeNode pre = null;
        Stack<TreeNode> stk = new Stack<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }

            root = stk.pop();
            if (pre != null && p.val == root.val)
                return pre;

            pre = root;
            root = root.right;
        }

        return null;
    }
}
