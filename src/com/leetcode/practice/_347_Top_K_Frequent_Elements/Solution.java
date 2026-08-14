package com.leetcode.practice._347_Top_K_Frequent_Elements;


import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }


        // bucket sort
        List<Integer>[] bucket = new List[nums.length + 1];
        for (var entry : freqMap.entrySet()) {
            if (bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }

        // get bucket sort res
        int[] res = new int[k];
        int index = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    res[index++] = num;
                    if (index >= k) return res;
                }
            }
        }
        return res;
    }








    public static int[] topKFrequentPQ(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }


        List<Integer>[] buckets = new List[nums.length - 1];
        for (Integer key : freqMap.keySet()) {
            Integer freq = freqMap.get(key);
            if (buckets[freq] == null) buckets[freq] = new ArrayList<>();
            buckets[freq].add(key);
        }


        int[] ans = new int[k];
        for (int i = buckets.length - 1; i >= 0 && k > 0; i--) {
            if (buckets[i] == null) continue;
            for (int j : buckets[i]) {
                ans[--k] = j;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
//        int[] nums = new int[] {1, 1, 1, 2, 2, 3};
        int[] nums = new int[] {1,2,1,2,1,2,3,1,3,2};
        System.out.println(Arrays.toString(topKFrequentPQ(nums, 2)));
    }
}
