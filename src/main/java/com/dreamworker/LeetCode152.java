package com.dreamworker;

public class LeetCode152 {

    public static void main(String[] args) {
        LeetCode152 solution = new LeetCode152();
        System.out.println(solution.maxProduct(new int[]{0, -2, -3}));
    }

    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        min[0] = nums[0];
        max[0] = nums[0];

        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if (nums[i] > 0) {
                if (max[i - 1] > 0) {
                    max[i] = max[i - 1] * nums[i];
                } else {
                    max[i] = nums[i];
                }

                if (min[i - 1] < 0) {
                    min[i] = min[i - 1] * nums[i];
                } else {
                    min[i] = nums[i];
                }
            } else if (nums[i] < 0) {
                if (max[i - 1] > 0) {
                    if (min[i - 1] < 0) {
                        max[i] = min[i - 1] * nums[i];
                    } else {
                        max[i] = nums[i];
                    }
                } else {
                    if (min[i - 1] == 0) {
                        max[i] = nums[i];
                    } else {
                        max[i] = min[i - 1] * nums[i];
                    }
                }

                if (min[i - 1] < 0) {
                    if (max[i - 1] > 0) {
                        min[i] = max[i - 1] * nums[i];
                    } else {
                        min[i] = nums[i];
                    }
                } else {
                    if (max[i - 1] == 0) {
                        min[i] = nums[i];
                    } else {
                        min[i] = max[i - 1] * nums[i];
                    }
                }
            } else {
                max[i] = min[i] = 0;
            }
        }

        int result = Integer.MIN_VALUE;
        for (int num : max) {
            result = Math.max(num, result);
        }

        return result;
    }
}
