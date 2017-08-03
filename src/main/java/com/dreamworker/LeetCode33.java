package com.dreamworker;

/**
 * Search in Rotated Sorted Array
 */
public class LeetCode33 {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2, 3};
        LeetCode33 solution = new LeetCode33();
        System.out.println(solution.search(nums, 0));
    }

    public int search(int[] nums, int target) {
        int pivotIndex = findPivot(nums, 0, nums.length - 1);
        if (pivotIndex == -1) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        int index = binarySearch(nums, 0, pivotIndex - 1, target);
        if (index != -1) {
            return index;
        }
        return binarySearch(nums, pivotIndex, nums.length - 1, target);
    }

    public int findPivot(int[] nums, int start, int end) {
        if (end == start + 1) {
            return end;
        }

        if (end == start) {
            return -1;
        }

        int middle = start + ((end - start) >> 1);
        if (nums[middle] > nums[start]) {
            return findPivot(nums, middle, end);
        } else {
            return findPivot(nums, start, middle);
        }
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        if (target < nums[start] || target > nums[end]) {
            return -1;
        }

        while (start <= end) {
            int middle = start + ((end - start) >> 1);
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        return -1;
    }
}
