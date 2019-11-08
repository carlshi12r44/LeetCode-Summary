public class mergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 1 -> 2 -> 4 and 1 -> 3 -> 4
        // the problem that we need to solve is to run the sorting while doing the
        // we can use a heap/array to maintain such order so it would be in ascending order
        // then we can create a new list from heap
        // Or we can do it just by comparing each node values
        // l3 null -> 1 -> 1 -> 2 -> 3 -> 4
        // l1v = 1 l2 val = 1 l1v <= l2v -- put l1 to l3 l1 ++
        // l1v = 2 l2 val = 1 l1v > l2v --  put l2 to l3 l2 ++
        // l1v = 2 l2 val = 3 l1v <= l2v -- put l1 to l3 l1 ++
        // l1v = 4 l2 val = 3 l1v > l2v --  put l2 to l3 l2 ++
        // l1v = 4 l2 val = 4 l1v <= l2v -- put l1 to l3 l1++
        // now l1 is empty, l2 still have 4 left
        // then we need to add the left node in l2 to the list
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode l3 = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }

            l3 = l3.next;
        }

        // check if l1 or l2 has left
        if (l1 != null) {
            l3.next = l1;


        }

        if (l2 != null) {
            l3.next = l2;

        }

        return dummy.next;
    }
}
