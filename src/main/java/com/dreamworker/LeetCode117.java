package com.dreamworker;

public class LeetCode117 {

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                TreeLinkNode temp = root.next;
                while (temp != null && (temp.left == null && temp.right == null)) {
                    temp = temp.next;
                }
                if (temp != null) {
                    root.left.next = temp.left != null ? temp.left : temp.right;
                }
            }
        }

        connect(root.right);
        connect(root.left);
    }

    private static class TreeLinkNode {

        int val;

        TreeLinkNode left;

        TreeLinkNode right;

        TreeLinkNode next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}
