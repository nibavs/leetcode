package com.leetcode.practice._300_Longest_Increasing_Subsequence;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        List<Integer> res = new ArrayList<>();
        res.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            Integer largest = res.get(res.size() - 1);
            if (nums[i] > largest) {
                res.add(nums[i]);
            } else if (nums[i] == largest) {
                continue;
            } else {
                res.set(bsIndex(res, nums[i]), nums[i]);
            }
        }

        return res.size();
    }

    private static int bsIndex(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;
            if (arr.get(mid) == target) {
                return mid;
            } else if (arr.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        //        [10,9,2,5,3,7,101,18]
        int[] arr = new int[] {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(arr));
    }

}
