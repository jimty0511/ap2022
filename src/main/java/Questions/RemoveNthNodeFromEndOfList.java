package Questions;

import Objects.ListNode;

public class RemoveNthNodeFromEndOfList {
    /**
     * Lint 174
     *
     * @param head: The first node of linked list.
     * @param n:    An integer
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if (head == null)
            return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy, right = dummy;
        while (n-- > 0) {
            right = right.next;
        }

        while (right.next != null) {
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;
        return dummy.next;
    }
}
