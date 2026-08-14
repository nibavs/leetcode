package com.leetcode.practice._219_Contains_Duplicate_II;


import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (seen.containsKey(nums[i]) && Math.abs(seen.get(nums[i]) - i) <= k) {

                return true;

            }
            seen.put(nums[i], i);

        }
        return false;
    }

}
