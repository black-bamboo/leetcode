package com.dreamworker;

import java.util.ArrayList;
import java.util.List;

public class LeetCode216 {

    public static void main(String[] args) {
        LeetCode216 solution = new LeetCode216();
        solution.combinationSum3(3, 9);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> stack = new ArrayList<Integer>();
        combinationSum3(n - 3, k, n, stack, result);
        return result;
    }

    public void combinationSum3(int m, int k, int n, List<Integer> stack, List<List<Integer>> result) {
        if (k == 1) {
            ArrayList<Integer> item = new ArrayList<Integer>(stack);
            item.add(n);
            result.add(item);
            return;
        }

        int sum = m * (m - 1) / 2;
        if (sum < n) {
            stack.add(m);
            combinationSum3(m - 1, k - 1, n - m, stack, result);
            stack.remove(stack.size() - 1);
            return;
        }

        if (m >= n) {
            combinationSum3(m - 1, k, n, stack, result);
            return;
        }

        stack.add(m);
        combinationSum3(m - 1, k - 1, n - m, stack, result);
        stack.remove(stack.size() - 1);

        combinationSum3(m - 1, k, n, stack, result);
    }
}
