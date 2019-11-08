
public class reverseLinkedList {
    public ListNode reverseList(ListNode head) {
        //  null <- 1 -> 2 -> 3 -> 4 -> 5 -> NULL
        //   ^      ^    ^
        //   prev cur  next
        //  null <- 1 <- 2 <- 3 <- 4 <- 5 -> null
        //                              ^    ^    ^
        //                             prev cur  next
        // from where to where to reverse?
        // we want to reverse each two nodes
        // 1. take down the cur next node since we are
        // 2. break the connection between every two node and point from the current back to prev
        // 3. move the prev to current, move current to next
        // 4. after the while loop, return the prev
        ListNode cur = head, prev = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }

        return prev;
    }
}
