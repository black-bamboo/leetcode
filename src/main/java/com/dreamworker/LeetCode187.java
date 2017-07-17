package com.dreamworker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LeetCode187 {

    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() < 10) {
            return Collections.emptyList();
        }

        int length = s.length();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i <= length - 10; i++) {
            String sub = s.substring(i, i + 10);
            Integer count = map.get(sub);
            if (count == null) {
                map.put(sub, 1);
            } else {
                map.put(sub, count + 1);
            }
        }

        List<String> result = new ArrayList<String>();
        for (String key : map.keySet()) {
            if (map.get(key) > 1) {
                result.add(key);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
