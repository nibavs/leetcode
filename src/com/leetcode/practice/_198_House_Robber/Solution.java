package com.leetcode.practice._198_House_Robber;

public class Solution {

    //    prevPrevMax = 0, prevMax = 0
    // 2 -> 2 prevPrevMax += 2
    // 2, 7 -> prevMax || 7
    // 2, 7, 9 -> prevMax
    // 9
    // 2, 7, 9, 3
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int prevPrevMax = 0;
        int prevMax = 0;

        for (int num : nums) {
            int currentMax = Math.max(prevMax, prevPrevMax + num);
            prevPrevMax = prevMax;
            prevMax = currentMax;
        }

        return prevMax;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];


        //Input: nums = [1,2,3,4]
        // [1,1,2,6]
        // [24,12,4,1]
        //Output: [24,12,8,6]
        int cur = 1;
        for (int i = 0; i < nums.length; i++) {
            ans[i] = cur;
            cur *= nums[i];
        }
        cur = 1;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            ans[i] *= cur;
            cur *= nums[i];
        }
        return ans;

    }

}
