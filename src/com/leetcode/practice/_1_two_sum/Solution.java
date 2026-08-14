package com.leetcode.practice._1_two_sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueIdxMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int expected = target - nums[i];
            if (valueIdxMap.containsKey(expected)) {
                return new int[] {valueIdxMap.get(expected), i};
            }
            valueIdxMap.put(nums[i], i);
        }
        throw new RuntimeException();
    }
}
