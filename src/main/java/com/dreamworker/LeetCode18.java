package com.dreamworker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode18 {

    public static void main(String[] args) {
        LeetCode18 solution = new LeetCode18();
        List<List<Integer>> result = solution.fourSum(new int[]{-5, -2, -1, 0, 0, 0, 1, 3, 5}, 6);
        for (List<Integer> list : result) {
            for (int item : list) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);

        if (nums.length == 4) {
            for (int i = 0; i < 4; i++) {
                target -= nums[i];
            }
            if (target == 0) {
                return Collections.singletonList(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
            } else {
                return Collections.emptyList();
            }
        }

        int length = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i <= length - 4; i++) {
            // remove duplicate
            while (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                i++;
            }
            for (int j = i + 1; j <= length - 2; j++) {
                if (j - 1 >= 0 && j - 1 != i && nums[j - 1] == nums[j]) {
                    continue;
                }
                int sum = nums[i] + nums[j];
                int left = target - sum;
                int p = j + 1;
                int q = length - 1;
                while (p < q) {
                    if (nums[p] + nums[q] == left) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));
                        // remove duplicate
                        do {
                            q--;
                        } while (q > p && nums[q] == nums[q + 1]);
                        // remove duplicate
                        do {
                            p++;
                        } while (p < q && nums[p] == nums[p - 1]);
                    } else if (nums[p] + nums[q] > left) {
                        q--;
                    } else {
                        p++;
                    }
                }
            }
        }

        return result;
    }
}
