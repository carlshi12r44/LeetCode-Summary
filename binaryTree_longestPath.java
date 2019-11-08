package com.yifeng;


public class binaryTree_longestPath {
    static int maxSum = Integer.MIN_VALUE;
    static int maxLen = 0;
    public static int binaryTreeLongestPath(TreeNode root) {
        if (root == null) {
            return 0;
        }


        // root, maxSum, maxLen, curSum, curLen
        // curSum = 0
        // curLen = 0
        helper(root,0, 0);
        return maxSum;
    }

    private static void helper(TreeNode root, int curSum, int curLen) {
        // if this true meaning we reach to the leaf of the tree
        if (root == null) {
            if (maxLen < curLen) {
                maxLen = curLen;
                maxSum = curSum;
            } else if (maxLen == curLen && maxSum < curSum) {
                maxSum = curSum;
            }
            return;
        }

        // do this for left and right
        helper(root.left,curSum + root.val, curLen + 1);
        helper(root.right,curSum + root.val, curLen + 1);
    }

    public static void main(String[] args) {
        // binary tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.left.right.left = new TreeNode(6);

        System.out.println(binaryTreeLongestPath(root));
    }
}
