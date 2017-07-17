package com.dreamworker;

public class LeetCode201 {

    public static void main(String[] args) {
        LeetCode201 solution = new LeetCode201();
        System.out.println("result : " + solution.rangeBitwiseAnd(0, 1));
    }

    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }

        int result = 0;
        for (int i = 1; i < 31; i++) {
            long c = 2L << i;
            int mBlock = (int) (m / c);
            int nBlock = (int) (n / c);
            if (mBlock == nBlock) {
                int mIndex = (int) (m % c);
                int nIndex = (int) (n % c);
                if (mIndex >= c / 2 && nIndex >= c / 2) {
                    result |= 1 << i;
                    System.out.println(result);
                }
            }
        }
        return result;
    }
}
