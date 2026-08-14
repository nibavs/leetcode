package com.leetcode.practice._3_Longest_Substring_Without_Repeating_Characters;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while(seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left++));
            }
            seen.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public int lengthOfLongestSubstringMap(String s) {
        Map<Character, Integer> seen = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            if (seen.containsKey(s.charAt(right))) {
                left = Math.max(left, seen.get(s.charAt(right)) + 1);
            }
            maxLength = Math.max(maxLength, right - left + 1);
            seen.put(s.charAt(right), right);
        }

        return maxLength;
    }

    public static void main(String[] args) {


    }
}
