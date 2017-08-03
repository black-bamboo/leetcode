package com.dreamworker;

/**
 * 202 Happy Number
 */
public class LeetCode202 {

    public static void main(String[] args) {
        LeetCode202 solution = new LeetCode202();
        System.out.println(solution.isHappy(2));
    }

    public boolean isHappy(int n) {
        int slow, fast;
        slow = fast = n;

        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
        } while (slow != fast);

        return slow == 1;
    }

    private int digitSquareSum(int n) {
        int sum = 0, tmp;
        while (n > 0) {
            tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }
}
