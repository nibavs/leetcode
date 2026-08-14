package com.leetcode.practice._112_Path_Sum;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int x) {
            val = x;
        }

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (root.right == null && root.left == null) {
            return targetSum == root.val;
        }

        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);

        return left || right;
    }

    public boolean hasPathSumIter(TreeNode root, int targetSum) {
        if (root == null) return false;

        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> sums = new ArrayDeque<>();

        stack.push(root);
        sums.push(root.val);

        while (!stack.isEmpty()) {
            root = stack.pop();
            int sum = sums.pop();

            if (root.left == null && root.right == null && sum == targetSum) return true;

            if (root.left != null) {
                stack.push(root.left);
                sums.push(root.left.val + sum);
            }

            if (root.right != null) {
                stack.push(root.right);
                sums.push(root.right.val + sum);
            }
        }

        return false;
    }


}
