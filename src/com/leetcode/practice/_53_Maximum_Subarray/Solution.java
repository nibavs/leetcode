package com.leetcode.practice._53_Maximum_Subarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        int globalMax = nums[0];
        int localMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            localMax = Math.max(nums[i], localMax + nums[i]);
            globalMax = Math.max(globalMax, localMax);
        }

        return globalMax;
    }
}
