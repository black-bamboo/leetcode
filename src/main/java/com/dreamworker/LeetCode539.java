package com.dreamworker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode539 {

    public static void main(String[] args) {
        LeetCode539 solution = new LeetCode539();
        System.out.println(solution.findMinDifference(Arrays.asList("23:59", "00:00")));
    }

    public int findMinDifference(List<String> timePoints) {
        List<Integer> timePoints2 = new ArrayList<Integer>(timePoints.size());
        for (String s : timePoints) {
            String[] items = s.split(":");
            timePoints2.add(Integer.parseInt(items[0]) * 60 + Integer.parseInt(items[1]));
        }
        Collections.sort(timePoints2);

        int min = Integer.MAX_VALUE;
        int length = timePoints.size();
        for (int i = 0; i < length - 1; i++) {
            min = Math.min(min, timePoints2.get(i + 1) - timePoints2.get(i));
        }

        min = Math.min(min, 1440 - timePoints2.get(length - 1) + timePoints2.get(0));
        return min;
    }
}
