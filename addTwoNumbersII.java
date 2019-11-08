
import java.util.*;

public class addTwoNumbersII {
    public ListNode addTwoNumbersII(ListNode l1, ListNode l2) {
        // (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
        // reverse two linked lists
        // 3 -> 4 -> 2 -> 7 + 4 -> 6 -> 5 -> 7
        // 7 -> 0 -> 8 -> 7
        // reverse the result linked list
        // 7 -> 8 -> 0 -> 7

        // or we can use some data struture to manipulate the reverse process
        // if we can use two stacks to push each node in each linked list
        // we would have the reversed order
        // to handle the non-exist case, we can see if the stack is empty, then we can push a 0 into the stack

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // push elements in the two stacks
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        // define our preSum and carry
        int preSum = 0;
        int carry = 0;


        ListNode l3 = null;

        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            // handle non-exist nodes
            while (stack1.isEmpty()) {
                stack1.push(0);
            }

            while (stack2.isEmpty()) {
                stack2.push(0);
            }


            preSum = stack1.pop() + stack2.pop() + carry;
            carry = preSum / 10;

            int lastDigit = preSum % 10;

            ListNode newNode = new ListNode(lastDigit);
            // newNode 7 l3 null
            // 7 -> null
            // ^
            // newNode 0 l3 7
            // 0 -> 7 -> null
            // ^
            // newNode 8 l3 0
            // 8 -> 0 -> 7 -> null
            // ^
            // newNode 7 l3 8
            // 7 -> 8 -> 0 -> 7 -> null
            // ^
            newNode.next = l3;

            l3 = newNode;
        }

        return l3;
    }
}
