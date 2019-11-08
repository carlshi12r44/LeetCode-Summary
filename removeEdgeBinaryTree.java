package com.yifeng;

import java.util.HashSet;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int _val) {
        this.val = _val;
        this.left = this.right = null;
    }
}

public class removeEdgeBinaryTree {

    // what if the tree is BST?
    public static TreeNode removeEdgeBST(TreeNode root) {
        return removeEdgeBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static TreeNode removeEdgeBSTHelper(TreeNode node, long min, long max) {
        if (node == null) return null;
        if ((node.val <= min) || (node.val >= max)) return null;
        node.left = removeEdgeBSTHelper(node.left, min, node.val);
        node.right = removeEdgeBSTHelper(node.right, node.val, max);

        return node;
    }



    public static TreeNode removeEdge(TreeNode root) {
        return removeEdgeHelper(root, new HashSet<>());
    }



    private static TreeNode removeEdgeHelper(TreeNode root, HashSet<TreeNode> set) {
        if (root == null || !set.add(root)) return null;

        root.left = removeEdgeHelper(root.left, set);
        root.right = removeEdgeHelper(root.right, set);

        return root;

    }

    public static void main(String[] args) {

    }
}
