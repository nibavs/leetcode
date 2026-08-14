package com.leetcode.practice._76_Minimum_Window_Substring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static String minWindow(String s, String t) {
        String res = "";
        if (s == null || t == null || s.length() < t.length()) return res;

        int[] freqMap = new int[128];

        // Заполняем мапу
        for (int i = 0; i < t.length(); i++) {
            freqMap[t.charAt(i)]++;
        }

        // Идем по строке в поисках
        int left = 0;
        int right = 0;
        int counter = t.length();
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;
        int len = s.length();

        while (right < len) {
            if (freqMap[s.charAt(right)] > 0) counter--;

            freqMap[s.charAt(right)]--;
            right++;

            while (counter == 0) {
                if (right - left < minLength) {
                    minStart = left;
                    minLength = right - left;

                }
                freqMap[s.charAt(left)]++;
                if (freqMap[s.charAt(left)] > 0) counter++;
                left++;
            }
        }
        if (minLength != Integer.MAX_VALUE) {
            res = s.substring(minStart, minStart + minLength);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cabwefgewcwaefgcf", t = "cae";
        System.out.println(minWindow(s, t));
    }
}
