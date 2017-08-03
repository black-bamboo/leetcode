package com.dreamworker;

/**
 * 263 Ugly Number
 */
public class LeetCode263 {

    public static void main(String[] args) {
        LeetCode263 solution = new LeetCode263();
        solution.isUgly(7);
    }

    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }

        if (num == 1) {
            return true;
        }

        if (num % 2 != 0 && num % 3 != 0 && num % 5 != 0) {
            return false;
        } else if (num % 2 == 0) {
            return isUgly(num / 2);
        } else if (num % 3 == 0) {
            return isUgly(num / 3);
        } else {
            return isUgly(num / 5);
        }
    }
}
