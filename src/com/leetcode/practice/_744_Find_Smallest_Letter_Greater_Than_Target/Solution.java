package com.leetcode.practice._744_Find_Smallest_Letter_Greater_Than_Target;

public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;

        char smallest = letters[0];
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target >= letters[mid]) {
                left = mid + 1;
            } else if (target < letters[mid]) {
                smallest = letters[mid];
                right = mid - 1;
            }
        }

        return smallest;
    }
}
