package com.dreamworker;

public class LeetCode137 {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }

        int length = nums.length;
        if (((length / 3) & 1) == 0) {
            return result;
        } else {
            return ~result;
        }
    }
}
