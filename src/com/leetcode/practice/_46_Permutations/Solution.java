package com.leetcode.practice._46_Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), nums);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            ans.add(new ArrayList<>(tempList));
            return;
        }

        for (int num : nums) {
            if (!tempList.contains(num)) {
                tempList.add(num);
                backtrack(ans, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

}
