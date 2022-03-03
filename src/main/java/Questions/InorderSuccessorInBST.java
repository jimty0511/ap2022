package Questions;

import Objects.TreeNode;

import java.util.Stack;

public class InorderSuccessorInBST {
    /**
     * Lint 448
     *
     * @param root: The root of the BST.
     * @param p:    You need find the successor node of p.
     * @return: Successor of p.
     **/
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        TreeNode succ = null;
        while (root != null) {
            if (p.val >= root.val) {
                root = root.right;
            } else {
                succ = root;
                root = root.left;
            }
        }

        return succ;
    }

    public TreeNode two(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        Stack<TreeNode> stk = new Stack<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }

            root = stk.pop();
            if (succ != null && succ.val == p.val) {
                return root;
            }

            succ = root;
            root = root.right;
        }

        return null;
    }
}
