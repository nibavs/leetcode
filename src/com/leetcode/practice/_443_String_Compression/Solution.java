package com.leetcode.practice._443_String_Compression;

import java.util.Arrays;

public class Solution {
    public static int compress(char[] chars) {
        if (chars == null || chars.length == 0) return 0;

        int left = 0;
        int right = 0;

        while (right < chars.length) {
            char currentChar = chars[right];
            int counter = 0;
            while (right < chars.length && chars[right] == currentChar) {
                counter++;
                right++;
            }

            chars[left++] = currentChar;

            if (counter != 1) {
                for (char ch : String.valueOf(counter).toCharArray()) {
                    chars[left++] = ch;
                }
            }
        }

        return left;
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'a','a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compress(chars));
        System.out.println(Arrays.toString(chars));
    }
}
