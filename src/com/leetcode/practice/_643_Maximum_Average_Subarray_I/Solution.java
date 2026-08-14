package com.leetcode.practice._643_Maximum_Average_Subarray_I;


public class Solution {
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;

        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum * 1.0 / k;
    }

    public static void main(String[] args) {
//        int[] nums = new int [] {1, 12, -5, -6, 50, 3};
//        int[] nums1 = new int [] {0, 4, 0, 3, 2};
        int[] nums2 = new int [] {5};

        System.out.println(findMaxAverage(nums2, 1));

    }
}
