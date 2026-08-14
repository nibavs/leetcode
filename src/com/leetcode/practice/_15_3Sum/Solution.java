package com.leetcode.practice._15_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum3 = nums[i] + nums[j] + nums[k];

                if (sum3 == 0) {
                    ans.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j - 1] == nums[j]) j++;
                    while (j < k && nums[k + 1] == nums[k]) k--;
                } else if (sum3 < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }
}
