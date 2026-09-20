package com.leetcode.practice._14_Longest_Common_Prefix;

public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0 || strs[0].isEmpty()) return "";
        StringBuilder sb = new StringBuilder(strs[0]);

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(sb.toString())) {
                sb.deleteCharAt(sb.length() - 1);
                if (sb.isEmpty()) return "";
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"","",""};

        System.out.println(longestCommonPrefix(strs));
    }
}
