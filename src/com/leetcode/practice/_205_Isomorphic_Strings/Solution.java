package com.leetcode.practice._205_Isomorphic_Strings;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        Map<Character, Character> mapper = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            char value = t.charAt(i);
            if (mapper.containsKey(key)) {
                if (mapper.get(key) != value) return false;
            } else if (mapper.containsValue(value)) {
                return false;
            }else {
                mapper.put(key, value);
            }
        }

        return true;
    }

}
