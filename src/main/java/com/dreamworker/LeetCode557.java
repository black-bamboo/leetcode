package com.dreamworker;

/**
 * 557. Reverse Words in a String III
 */
public class LeetCode557 {

    public static void main(String[] args) {
        LeetCode557 solution = new LeetCode557();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        int length = s.length();
        StringBuilder t = new StringBuilder(length);

        int top = 0;
        char[] stack = new char[s.length()];

        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                if (top > 0) {
                    while (top > 0) {
                        t.append(stack[--top]);
                    }
                }
                t.append(' ');
            } else {
                stack[top] = s.charAt(i);
                top++;
            }
        }

        while (top > 0) {
            t.append(stack[--top]);
        }

        return t.toString();
    }
}
