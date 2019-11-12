import java.io.SequenceInputStream;

public class segmentTree {
    // TreeNode
    public class SegmentTreeNode {
        int start;
        int end;
        SegmentTreeNode left;
        SegmentTreeNode right;
        int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }

    SegmentTreeNode root;
    public segmentTree(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }
    // divide and conquer
    // we need to know the start and the target
    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        SegmentTreeNode cur = new SegmentTreeNode(start, end);

        // if start != end
        // then divide and conquer
        // if start == end
        // then the sum just equal to nums[left]

        if (start == end) {
            cur.sum = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            cur.left = buildTree(nums, start, mid);
            cur.right = buildTree(nums, mid + 1, end);
            cur.sum = cur.left.sum + cur.right.sum;
        }

        return cur;
    }

    public void update(int i, int val) {
        update(root, i, val);
    }

    // update the path
    // corner case: if start == end meaning we reach the leaf node
    // then divide and conquer
    private void update(SegmentTreeNode cur, int pos, int val) {
        if (cur.start == cur.end) {
            cur.sum = val;
            return;
        }

        int mid = cur.start + (cur.end - cur.start) / 2;
        // if pos smaller than mid --> left subtree

        if (pos <= mid) {
            update(cur.left, pos, val);
        } else {
            update(cur.right, pos, val);
        }

        cur.sum = cur.left.sum + cur.right.sum;
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private int sumRange(SegmentTreeNode cur, int start, int end) {
        if (cur.start == start && cur.end == end) {
            return cur.sum;
        }

        int mid = cur.start + (cur.end - cur.start) / 2;
        // if we want to have two sections when mid is inside [start, end]
        // only left section will be evaluated when  mid >= end
        // only right section will be evaluated when mid + 1<= start
        if (end <= mid) {
            return sumRange(cur.left, start, end);
        } else if (start >= mid + 1) {
            return sumRange(cur.right, start, end);
        } else {
            return sumRange(cur.left, start, mid) + sumRange(cur.right, mid + 1, end);
        }

    }
}
