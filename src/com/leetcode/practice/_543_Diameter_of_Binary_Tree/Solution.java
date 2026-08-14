package com.leetcode.practice._543_Diameter_of_Binary_Tree;


import java.util.*;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        recFunc(root);
        return max;
    }

    private int recFunc(TreeNode root) {

        if (root == null) return 0;

        int left = recFunc(root.left);
        int right = recFunc(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }

    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int res = 0;

        Map<Integer, Integer> prefSum = new HashMap<>();
        prefSum.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (prefSum.containsKey(sum - k)) {
                res += prefSum.get(sum - k);
            }
            prefSum.put(sum, prefSum.getOrDefault(sum, 0) + 1);
        }
        return res;
    }





}
