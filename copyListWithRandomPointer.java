import java.util.HashMap;
import java.util.Map;

class RandomNode {
    public int val;
    public RandomNode next;
    public RandomNode random;

    public RandomNode(int val) {
        this.val = val;
    }

    public RandomNode(int _val,RandomNode _next,RandomNode _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
public class copyListWithRandomPointer {
    public RandomNode copyRandomList(RandomNode head) {
        // what kind of questions you can think of?
        // 1. how to copy the next pointer?
        // 2. how to copy the random pointer?
        // to do that we need to think of which data structure we need to use?
        // for this we can use a HashMap to store the Node and its clone Node without any next or random mapping
        // then we can use a second loop to copy the list

        if (head == null) {
            return null;
        }
        // use HashMap to clone each node
        Map<RandomNode, RandomNode> map = new HashMap<>();
        RandomNode start = head;
        while (start != null) {
            map.put(start, new RandomNode(start.val));
            start = start.next;
        }



        // for each node, we need to traverse the
        start = head;
        while (start != null) {
            map.get(start).next = map.get(start.next);
            map.get(start).random = map.get(start.random);
            start = start.next;
        }

        return map.get(head);
    }

}
