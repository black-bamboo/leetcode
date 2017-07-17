package com.dreamworker;

public class LeetCode520 {

    private static final int STATE_0 = 0;

    private static final int STATE_1 = 1;

    private static final int STATE_2 = 2;

    private static final int STATE_3 = 3;

    private static final int STATE_4 = 4;

    public static void main(String[] args) {
        LeetCode520 solution = new LeetCode520();
        System.out.println(solution.detectCapitalUse("FFFFFFFFFFFFFFFFFFFFf"));
    }

    public boolean detectCapitalUse(String word) {
        int state = STATE_0;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            switch (state) {
                case STATE_0:
                    if (Character.isUpperCase(word.charAt(i))) {
                        state = STATE_1;
                    } else {
                        state = STATE_4;
                    }
                    break;

                case STATE_1:
                    if (Character.isUpperCase(word.charAt(i))) {
                        state = STATE_3;
                    } else {
                        state = STATE_2;
                    }
                    break;

                case STATE_2:
                    if (Character.isUpperCase(word.charAt(i))) {
                        return false;
                    }
                    break;

                case STATE_3:
                    if (Character.isLowerCase(word.charAt(i))) {
                        return false;
                    }
                    break;

                case STATE_4:
                    if (Character.isUpperCase(word.charAt(i))) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}
