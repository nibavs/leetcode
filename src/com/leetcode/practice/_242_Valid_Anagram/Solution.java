package com.leetcode.practice._242_Valid_Anagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sCounter = new HashMap<>();
        Map<Character, Integer> tCounter = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sCounter.put(s.charAt(i), 1 + sCounter.getOrDefault(s.charAt(i), 0));
            tCounter.put(t.charAt(i), 1 + tCounter.getOrDefault(t.charAt(i), 0));
        }

        return sCounter.equals(tCounter);
    }

    public boolean isAnagramSort(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }

    public boolean isAnagram26(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int [] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int j : freq) {
            if (j != 0) return false;
        }

        return true;
    }
























}
