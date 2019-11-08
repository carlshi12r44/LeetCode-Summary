import java.util.*;
public class mergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        // we need to think about a way to maintain the order of the all the sorted lists
        // one way to do it would be using heap, which can sort them in ascending order
        // then we can build the new lists from the heap

        // corner cases
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (ListNode head : lists) {
            // traverse head to get the node value and put it into the heap
            while (head != null) {
                heap.add(head.val);
                head = head.next;
            }
        }


        // now build a new list from the heap
        ListNode dummy = new ListNode(0);

        ListNode res = dummy;

        while (!heap.isEmpty()) {
            res.next = new ListNode(heap.poll());
            // traverse the res node
            res = res.next;
        }

        return dummy.next;
    }
}
