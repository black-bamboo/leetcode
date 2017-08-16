package com.dreamworker;

public class LeetCode540 {

    public static void main(String[] args) {
        LeetCode540 solution = new LeetCode540();
        //int[] nums = new int[] {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int[] nums = new int[] {1, 1, 2, 2, 4, 4, 5, 5, 9};
        System.out.println(solution.singleNonDuplicate(nums));
    }

    public int singleNonDuplicate(int[] nums) {
        return singleNonDuplicate(nums, 0, nums.length - 1);
    }

    public int singleNonDuplicate(int[] nums, int start, int end) {
        int n = end - start + 1;

        if (n == 3) {
            if (nums[start] == nums[start + 1]) {
                return nums[end];
            } else {
                return nums[start];
            }
        }

        int m = n / 2 + start;
        if (nums[m] != nums[m - 1] && nums[m] != nums[m + 1]) {
            return nums[m];
        } else {
            if ((m & 1) == 0) {
                if (nums[m] == nums[m - 1]) {
                    return singleNonDuplicate(nums, 0, m);
                } else {
                    return singleNonDuplicate(nums, m, end);
                }
            } else {
                if (nums[m] == nums[m - 1]) {
                    return singleNonDuplicate(nums, m + 1, end);
                } else {
                    return singleNonDuplicate(nums, 0, m - 1);
                }
            }
        }
    }
}
