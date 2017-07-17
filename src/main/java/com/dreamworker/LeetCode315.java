package com.dreamworker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode315 {

    class TreeNode{
        int smallCount;
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int count, int val){
            this.smallCount = count;
            this.val = val;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        TreeNode root = null;
        Integer[] ret = new Integer[nums.length];
        for(int i = nums.length - 1; i >= 0; i--){
            root = insert(root, nums[i], ret, i, 0);
        }
        return Arrays.asList(ret);
    }

    public TreeNode insert(TreeNode root, int val, Integer[] ans, int index, int preSum){
        if (root == null) {
            root = new TreeNode(0, val);
            ans[index] = preSum;
        } else if (root.val>val) {
            root.smallCount++;
            root.left = insert(root.left, val, ans, index, preSum);
        } else {
            // only adding 1 on preSum if root.val is only smaller than val
            root.right = insert(root.right, val, ans, index, root.smallCount + preSum + (root.val < val ? 1 : 0));
        }
        return root;
    }
}
