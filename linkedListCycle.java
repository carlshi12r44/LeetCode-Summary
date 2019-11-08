public class linkedListCycle {
    public boolean hasCycle(ListNode head) {
        // to determine if there is a cycle in the LinkedList
        // we need to know 1 thing first, which is to traverse the linked list
        // image we are two people running on the playground which has a cycle
        // we would meet eventually if the playground has cycle
        // faster person moves 2 steps, and slow person moves 1 step
        // so basically we want to have two pointers in the linked list
        // if they can meet while traversing the linked list return true
        // if they can not, return false
        // 1 -> 2 -> 3 pos = 1
        //      |    |
        //      -----
        // s    f
        //      f      true
        // 1 -> 2 -> 3
        //           s    f
        //              false

        // but we also need to consider some corner cases, when there is no nodes or the node is only one, the cycle does not exist

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head, fast = head.next;

        while (slow != fast) {
            // no cycle
            if (fast.next == null || fast.next.next == null) {
                return false;
            }

            fast = fast.next.next;
            slow = slow.next;


        }

        return true;
    }
}
