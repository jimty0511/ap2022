package Questions;

import Objects.ListNode;

public class NthToLastNodeInList {
    /**
     * Lint 166
     *
     * @param head: The first node of linked list.
     * @param n:    An integer
     * @return: Nth to last node of a singly linked list.
     */
    public ListNode nthToLast(ListNode head, int n) {
        // write your code here
        if (head == null)
            return null;

        ListNode right = head;
        while (n-- > 0) {
            right = right.next;
        }

        ListNode left = head;
        while (right != null) {
            left = left.next;
            right = right.next;
        }

        return left;
    }
}
