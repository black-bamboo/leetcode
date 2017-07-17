package com.dreamworker;

public class LeetCode99 {

    private TreeNode firstElement;

    private TreeNode secondElement;

    private TreeNode prevElement;

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 0;

        TreeNode left = new TreeNode();
        left.val = 1;

        root.left = left;

        LeetCode99 solution = new LeetCode99();
        solution.recoverTree(root);
    }

    public void recoverTree(TreeNode root) {

        // In order traversal to find the two elements
        traverse(root);

        // Swap the values of the two nodes
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private void traverse(TreeNode root) {
        if (root == null)
            return;

        traverse(root.left);

        // Start of "do some business",
        // If first element has not been found, assign it to prevElement (refer to 6 in the example above)
        if (firstElement == null && prevElement != null && prevElement.val >= root.val) {
            firstElement = prevElement;
        }

        // If first element is found, assign the second element to the root (refer to 2 in the example above)
        if (firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }
        prevElement = root;

        // End of "do some business"

        traverse(root.right);
    }

    static class TreeNode {

        TreeNode left;

        TreeNode right;

        int val;
    }
}
