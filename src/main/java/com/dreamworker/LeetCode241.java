package com.dreamworker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode241 {

    private List<Integer>[][] cache;

    public List<Integer> diffWaysToCompute(String input) {
        String[] tokens = parse(input);
        cache = new List[tokens.length][tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            cache[i] = new List[tokens.length];
        }

        return diffWaysToCompute(tokens, 0, tokens.length - 1);
    }

    public String[] parse(String input) {
        ArrayList<String> tokens = new ArrayList<String>();
        int i = 0;
        while (i < input.length()) {
            if (input.charAt(i) == '+') {
                tokens.add("+");
                i++;
            } else if (input.charAt(i) == '-') {
                tokens.add("-");
                i++;
            } else if (input.charAt(i) == '*') {
                tokens.add("*");
                i++;
            } else {
                StringBuilder builder = new StringBuilder();
                while (i < input.length() && input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                    builder.append(input.charAt(i));
                    i++;
                }
                tokens.add(builder.toString());
            }
        }
        String[] result = new String[tokens.size()];
        result = tokens.toArray(result);
        return result;
    }

    public List<Integer> diffWaysToCompute(String[] tokens, int from, int to) {
        if (from > to) {
            return Collections.emptyList();
        }

        if (from == to) {
            return Collections.singletonList(Integer.parseInt(tokens[from]));
        }

        if (cache[from][to] != null) {
            return cache[from][to];
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int i = from; i <= to; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*")) {
                List<Integer> left = diffWaysToCompute(tokens, from, i - 1);
                List<Integer> right = diffWaysToCompute(tokens, i + 1, to);

                for (Integer aLeft : left) {
                    for (Integer aRight : right) {
                        if (tokens[i].equals("+")) {
                            result.add(aLeft + aRight);
                        } else if (tokens[i].equals("-")) {
                            result.add(aLeft - aRight);
                        } else if (tokens[i].equals("*")) {
                            result.add(aLeft * aRight);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main( String[] args ) {
        LeetCode241 solution = new LeetCode241();
        solution.diffWaysToCompute("2-1-1");
    }
}
