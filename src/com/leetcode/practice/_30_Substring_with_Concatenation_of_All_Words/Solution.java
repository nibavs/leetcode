package com.leetcode.practice._30_Substring_with_Concatenation_of_All_Words;

import java.util.*;

public class Solution {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return ans;

        int wordLength = words[0].length();
        int seqLen = wordLength * words.length;

        Map<String, Integer> freqMap = new HashMap<>();
        for (String w : words) {
            freqMap.put(w, freqMap.getOrDefault(w, 0) + 1);
        }

        for (int offset = 0; offset < wordLength; offset++) {
            int left = offset;
            int right = offset;
            int matched = 0;
            Map<String, Integer> window = new HashMap<>();

            while (right + wordLength <= s.length()) {
                String sub = s.substring(right, right + wordLength);
                right += wordLength;

                if (freqMap.containsKey(sub)) {
                    window.put(sub, window.getOrDefault(sub, 0) + 1);
                    matched++;

                    while(window.get(sub) > freqMap.get(sub)) {
                        String lw = s.substring(left, left + wordLength);
                        window.put(lw, window.get(lw) - 1);
                        left += wordLength;
                        matched--;
                    }

                    if (matched == words.length) {
                        ans.add(left);

                        String lw = s.substring(left, left + wordLength);
                        window.put(lw, window.get(lw) - 1);
                        left += wordLength;
                        matched--;
                    }

                } else {
                    window.clear();
                    matched = 0;
                    left = right;
                }

            }

        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = new String[] {"foo", "bar"};
        System.out.println(findSubstring(s, words));
    }
}
