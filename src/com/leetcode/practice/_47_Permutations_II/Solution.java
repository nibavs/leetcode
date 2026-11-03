package com.leetcode.practice._47_Permutations_II;

import java.util.*;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums, ans, new ArrayList<>(), used);
        return ans;
    }

    private void backtracking(int[] nums, List<List<Integer>> ans, List<Integer> tempList, boolean[] used) {
        if (tempList.size() == nums.length) {
            ans.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
            tempList.add(nums[i]);
            used[i] = true;
            backtracking(nums, ans, tempList, used);
            tempList.remove(tempList.size() - 1);
            used[i] = false;

        }
    }
}
