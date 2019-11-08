public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // (2 -> 4 -> 3) + (5 -> 6 -> 4) -> 7 -> 0 -> 8
        // 342 + 465 = 807
        // both in reverse order
        // 1. reverse back the linked lists
        // 2. merge each node on the list
        // this approach has problem which it would not count the carry for the merge
        // what if they are not the same length?
        // say (2 -> 4) + (1 -> 2 -> 3)
        // (42 + 321) = 363
        // what if we can mark the non-exist node with value of 0?
        // (2 -> 4 -> 0) + (1 -> 2 -> 3) because is in reverse order
        // so the sum would just be the same
        // how to solve the carry in the merge?
        // store the carry as the sum % 10 if the sum > 10?

        // so my algo would be:
        // traverse each node
        // for each node in l1 and l2, we could see if it is null or not, if null -- 0
        // check if sum is greater than 10? if yes we mark carry to be the sum / 10 and the last digit we want to add is sum % 10

        // we let the next node of the new list to be the node with the last digit value
        // (2 -> 4 -> 3) + (5 -> 6 -> 4)
        // l1 2 l2 5 carry 0 lastDigit 0 preSum 2+5+carry = 7 -- carry = presum / 10 = 0 lastDigit = presum % 10 = 7 l3.next = node(7)

        // l1 4 l2 6 carry 0 lastDigit 0 preSum 4+6+carry = 10 -- carry = presum / 10 = 1 lastDigit = 10 % 10 = 0 l3.next = 0
        // l1 3 l2 4 carry 1 lastDigit 0 preSum 3+4+carry = 8  -- carry = presum / 10 = 0 lastDigit = 8  % 10 = 8 l3.next = 8
        // l3: 7 -> 0 -> 8




        ListNode dummy = new ListNode(0);
        ListNode l3 = dummy;

        // define the carry
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;

            int preSum = l1Val + l2Val + carry;
            carry = preSum / 10;
            int lastDigit = preSum % 10;
            // put lastDigit to the l3's next node
            l3.next = new ListNode(lastDigit);

            // traverse l1 and l2
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

            // traverse l3
            l3 = l3.next;
        }
        // handle the carry which got left
        // carry  = 1 after the merge
        // so new list is one more node than the merging lists



        return dummy.next;
    }
}
