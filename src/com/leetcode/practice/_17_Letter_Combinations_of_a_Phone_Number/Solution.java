package com.leetcode.practice._17_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private static String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        backtrack(0, digits, sb, res);
        return res;
    }

    private static void backtrack(int i, String digits, StringBuilder sb, List<String> res) {
        if (i == digits.length()) {
            res.add(sb.toString());
            return;
        }

        int bucketIndex = digits.charAt(i) - '0';

        for (char ch : map[bucketIndex].toCharArray()) {
            sb.append(ch);
            backtrack(i + 1, digits, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
