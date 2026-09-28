package com.leetcode.practice._1732_Find_The_Highest_Altitude;

public class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int prefixSum = 0;

        for (int g : gain) {
            prefixSum += g;
            max = Math.max(prefixSum, max);
        }
        return max;
    }
}
