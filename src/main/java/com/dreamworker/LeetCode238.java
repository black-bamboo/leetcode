package com.dreamworker;

public class LeetCode238 {

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int product = 1;
        for (int i = length - 1; i < length; i++) {
            product *= nums[i];
            result[i] = product;
        }

        product = 1;
        for (int i = 0; i < length - 1; i++) {
            result[i] = product * result[i + 1];
            product *= nums[i];
        }
        result[length - 1] = product;

        return result;
    }
}
