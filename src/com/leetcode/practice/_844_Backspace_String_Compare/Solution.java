package com.leetcode.practice._844_Backspace_String_Compare;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static boolean backspaceCompare(String s, String t) {
        Deque<Character> stack = new ArrayDeque<>();
        Deque<Character> stack2 = new ArrayDeque<>();

        int counter = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            Character ch = s.charAt(i);
            if (ch == '#') {
                counter++;
            } else {
                if (counter != 0) {
                    counter--;
                } else {
                    stack.push(ch);
                }
            }
        }
        int counter2 = 0;
        for (int i = t.length() - 1; i >= 0; i--) {
            Character ch = t.charAt(i);
            if (ch == '#') {
                counter2++;
            } else {
                if (counter2 != 0) {
                    counter2--;
                } else {
                    stack2.push(ch);
                }
            }
        }

        return stack.equals(stack2);
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for(int right = 0; right < s.length(); right++) {
            Character ch = s.charAt(right);
            if (freqMap.containsKey(ch)) {
                left = freqMap.get(ch) + 1;
            }
            freqMap.put(ch, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
