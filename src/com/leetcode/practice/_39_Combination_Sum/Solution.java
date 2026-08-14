package com.leetcode.practice._39_Combination_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);
        backtrack(ans, new ArrayList<>(), candidates, target, 0);

        return ans;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) return;
        if (remain == 0) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            int value = nums[i];
            if (value > remain) break;
            tempList.add(value);
            backtrack(list, tempList, nums, remain - value, i);
            tempList.remove(tempList.size() - 1);
        }
    }
}
