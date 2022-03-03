package Questions;

import Objects.ListNode;

public class LinkedListCycle {
    /**
     * Lint 102
     *
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        // write your code here
        if (head == null)
            return false;

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.val == fast.val)
                return true;
        }

        return false;
    }
}
