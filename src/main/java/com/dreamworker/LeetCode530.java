package com.dreamworker;

public class LeetCode530 {

    private int min;

    private TreeNode prevNode;

    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        visit(root);
        return min;
    }

    public void visit(TreeNode root) {
        if (root.left != null) {
            visit(root.left);
        }

        if (prevNode != null) {
            int diff = Math.abs(prevNode.val - root.val);
            if (diff < min) {
                min = diff;
            }
        }
        prevNode = root;

        if (root.right != null) {
            visit(root.right);
        }
    }

    private static class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
