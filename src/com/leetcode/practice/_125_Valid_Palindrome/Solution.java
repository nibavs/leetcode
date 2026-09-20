package com.leetcode.practice._125_Valid_Palindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return true;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char lch = s.charAt(left);
            char rch = s.charAt(right);
            if (!Character.isLetterOrDigit(lch)) {
                left++;
            } else if (!Character.isLetterOrDigit(rch)) {
                right--;
            } else {
                if (Character.toLowerCase(lch) != Character.toLowerCase(rch)) return false;
            }

        }

        return true;
    }
}
