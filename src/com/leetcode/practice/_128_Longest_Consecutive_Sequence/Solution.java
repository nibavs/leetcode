package com.leetcode.practice._128_Longest_Consecutive_Sequence;


import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }
        int streak = 1;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int localStreak = 1;
                while(set.contains(n++ + 1)) {
                    localStreak += 1;
                }
                streak = Math.max(streak, localStreak);
            }

        }
        return streak;

    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 1, 2, 2, 3};
//        System.out.println(topKF(nums, 2));
    }
}
