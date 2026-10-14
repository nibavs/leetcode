package com.leetcode.practice._8_String_to_Integer_atoi;

class Solution {
    public int myAtoi(String s) {
        if (s == null || s.isBlank()) return 0;

        int iterator = 0;

        // step 1
        while (iterator < s.length() && s.charAt(iterator) == ' ') {
            iterator++;
        }

        // step 2
        int sign = s.charAt(iterator) == '-' ? -1 : 1;
        if (s.charAt(iterator) == '-' || s.charAt(iterator) == '+') iterator++;

        long res = 0;

        // step 3
        // leading zeros skipping
        while (iterator < s.length() && s.charAt(iterator) == '0') {
            iterator++;
        }

        // conversion
        while (iterator < s.length()) {
            char current = s.charAt(iterator++);
            if (current < '0' || current > '9') {
                break;
            }

            res = res * 10 + (current - '0');

            // step 4 Rounding
            if (sign == 1 && res >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (sign == -1 && res * -1 <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int) res * sign;
    }
}
