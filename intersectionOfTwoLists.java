public class intersectionOfTwoLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // to find the intersection one question to think about is if they connected?
        // if they are connected
        //           pB
        //A 1 -> 2 -> 3 -> 4
        //            |
        //B           2
        //            pA
        // we can have two pointers, pA on list A pB on listB,
        // so everytime pA and pB hits the end, so pA would point to the head of B
        // pB would point to the head of A
        // if they meet, then they would be returned

        // corner cases
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA, pB = headB;

        while (pA != pB) {
            // if hit the end, move it to the beginning
            if (pA == null) {
                pA = headA;
            }

            if (pB == null) {
                pB = headB;
            }

            pA = pA.next;
            pB = pB.next;
        }

        return pA;
    }
}
