public class validateBinaryTree {
    public boolean isValidBST(TreeNode root) {
        // First question that we need to ask is that
        // what is the characteristic of the BST?
        // 1. its left child is smaller than the root
        // 2. its right child is larger than the root
        // so we can use these 2 characteristics to actually perform the checking of the BST
        // then we can check if the left subtree fits the requirement and the right subtree
        // Example Walk-through:
        // [2,1,3]
        // 2 > Long.MIN_VALUE
        // 1 > Long.MIN_VALUE && 1 < 2 -- reach bottom of left subtree -- true
        // 3 < 2 ? no not going to the if statement -- reach bottom of the right subtree -- true
        // true && true -- true so return true
        if (root == null) return false;
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean check(TreeNode root, Long left, Long right) {
        //
        // if the root reaches the end then return true
        if (root == null) return true;

        // find the cases where the tree must not be BST
        // root.val
        if (root.val <= left || root.val >= right) {
            return false;
        }

        return check(root.left, left, (long) root.val) && check(root.right, (long) root.val, right);
    }
}
