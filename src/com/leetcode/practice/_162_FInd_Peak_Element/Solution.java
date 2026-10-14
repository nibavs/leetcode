package com.leetcode.practice._162_FInd_Peak_Element;

public class Solution {
    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;

        int left = 0;
        int right = nums.length - 1;

//        4 5 6 7 8
        while (left <= right) {
            int mid = left + (right - left)/2;
            int leftNeighbor = mid == 0 ? Integer.MIN_VALUE : nums[mid - 1];
            int rightNeighbor = mid == nums.length ? Integer.MIN_VALUE : nums[mid + 1];

            if (nums[mid] > leftNeighbor && nums[mid] > rightNeighbor) {
                return mid;
            } else if (rightNeighbor >= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}
