package com.leetcode.practice._15_3Sum;

import java.util.*;

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

    public static List<List<Integer>> threeSums(int[] nums) {
//         Input: nums = [-1,0,1,2,-1,-4]
//          Output: [[-1,-1,2],[-1,0,1]]
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int target = nums[i] + nums[left] + nums[right];
                if (target == 0) {
                    res.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (target > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSums(new int[]{-1,0,1,2,-1,-4}));
    }
}
