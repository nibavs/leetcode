package com.leetcode.practice._238_Product_of_Array_Except_Self;


import java.util.Arrays;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];

        int curr = 1;
        for (int i = 0; i < n; i++) {
            ans[i] = curr;
            curr *= nums[i];
        }

        curr = 1;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 1, 2, 2, 3};
//        System.out.println(topKF(nums, 2));
    }
}
