package com.leetcode.practice._28_Find_the_Index_of_the_First_Occurrence_in_a_String;

public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) return -1;

        for (int left = 0, right = needle.length(); right <= haystack.length(); left++, right++) {
            if (haystack.substring(left, right).equals(needle)) return left;
        }
        return -1;
    }
}
