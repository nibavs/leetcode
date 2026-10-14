package com.leetcode.practice._7_Reverse_Integer;

public class Solution {
    public static int reverse(int x) {
        int res = 0;

        while(x != 0) {
            int digit = x % 10;
            x = x/10;

            if (res < Integer.MIN_VALUE / 10
                    || (res == Integer.MIN_VALUE / 10 && digit < -8)
            ) {
                return 0;
            }

            if (res > Integer.MAX_VALUE / 10
                    || (res == Integer.MAX_VALUE / 10 && digit > 7)
            ) {
                return 0;
            }

            res = res * 10 + digit;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
    }
}
