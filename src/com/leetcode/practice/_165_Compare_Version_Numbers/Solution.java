package com.leetcode.practice._165_Compare_Version_Numbers;

public class Solution {
    public static int compareVersion(String version1, String version2) {
        if (version1.isBlank() && version2.isBlank()) return 0;

        String[] revisions1 = version1.split("\\.");
        String[] revisions2 = version2.split("\\.");

        int maxLen = Math.max(revisions1.length, revisions2.length);

        for (int i = 0; i < maxLen; i++) {
            int rev1 = 0;
            int rev2 = 0;

            if (i < revisions1.length) {
                rev1 = Integer.parseInt(revisions1[i]);
            }

            if (i < revisions2.length) {
                rev2 = Integer.parseInt(revisions2[i]);
            }

            if (rev1 > rev2) return 1;
            if (rev1 < rev2) return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.01", "1.001"));
    }
}
