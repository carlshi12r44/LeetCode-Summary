class JumpNode {
    int val;
    JumpNode next;
    JumpNode jump;
    public JumpNode(int _val) {
        this.val = _val;
        this.next = null;
        this.jump = null;
    }
}
public class searchLinkedListWithJumpReference {
    private void helper(JumpNode head, int level) {
        if (head == null || head.val == -1) {
            return;
        }

        head.val = level;
        level++;
        helper(head.jump, level);
        helper(head.next, level);

    }
    public void setJumpOrder(JumpNode head) {
        int level = 0;
        helper(head, level);
    }
}
