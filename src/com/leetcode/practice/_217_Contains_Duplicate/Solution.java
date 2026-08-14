package com.leetcode.practice._217_Contains_Duplicate;

import java.util.*;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> nu = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if (nu.contains(nums[i])) return true;
            nu.add(nums[i]);
        }

        return false;
    }
}
