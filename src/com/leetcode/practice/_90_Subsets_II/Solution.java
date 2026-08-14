package com.leetcode.practice._90_Subsets_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(ans, new ArrayList<>(), nums, 0);

        return ans;
    }

    private void backtrack(List<List<Integer>> ans, ArrayList<Integer> tempList, int[] nums, int start) {
        ans.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            tempList.add(nums[i]);
            backtrack(ans, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }


}
