package com.dreamworker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode491 {

    public static void main(String[] args) {
        LeetCode491 solution = new LeetCode491();
        List<List<Integer>> result = solution.findSubsequences(new int[]{4, 6, 7, 7});
        for (List<Integer> item : result) {
            for (int i : item) {
                System.out.print(i);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        ArrayList<Integer> stack = new ArrayList<Integer>(16);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        findSubsequences(nums, 0, stack, result);
        return removeDuplicate(result);
    }

    public List<List<Integer>> removeDuplicate(List<List<Integer>> result) {
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for (List<Integer> item : result) {
            set.add(item);
        }
        return new ArrayList<List<Integer>>(set);
    }

    public void findSubsequences(int[] nums, int index, List<Integer> stack, List<List<Integer>> result) {
        if (index == nums.length) {
            if (stack.size() > 1) {
                result.add(new ArrayList<Integer>(stack));
            }
            return;
        }

        if (stack.size() == 0) {
            stack.add(nums[index]);
            findSubsequences(nums, index + 1, stack, result);
            stack.remove(stack.size() - 1);
            findSubsequences(nums, index + 1, stack, result);
        } else {
            if (nums[index] >= stack.get(stack.size() - 1)) {
                stack.add(nums[index]);
                findSubsequences(nums, index + 1, stack, result);
                stack.remove(stack.size() - 1);
                findSubsequences(nums, index + 1, stack, result);
            } else {
                findSubsequences(nums, index + 1, stack, result);
            }
        }
    }
}
