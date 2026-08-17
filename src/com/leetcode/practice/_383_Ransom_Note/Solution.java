package com.leetcode.practice._383_Ransom_Note;



public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) return false;
        int[] int26 = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            int26[magazine.charAt(i) - 'a'] += 1;
            if (i < ransomNote.length()) {
                int26[ransomNote.charAt(i) - 'a'] -= 1;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (int26[i] < 0) return false;
        }

        return true;
    }
}
