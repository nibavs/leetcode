package com.leetcode.practice._300_Longest_Increasing_Subsequence;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int lengthOfLIS(int[] nums) {
//        [10,9,2,5,3,7,101,18]
        if (nums == null || nums.length == 0) return 0;

        List<Integer> res = new ArrayList<>();
        res.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int largestElem = res.get(res.size() - 1);
            if (nums[i] > largestElem) {
                res.add(nums[i]);
            } else if (nums[i] < largestElem) {
                res.set(bsIndex(res, nums[i]), nums[i]);
            }
        }

        return res.size();
    }

    private static int bsIndex(List<Integer> arr, int target) {
        int start = 0;
        int end = arr.size() - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid) == target) return mid;
            if (arr.get(mid) > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }


    public static void main(String[] args) {
        //        [10,9,2,5,3,7,101,18]
        int[] arr = new int[] {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(arr));
    }

}
