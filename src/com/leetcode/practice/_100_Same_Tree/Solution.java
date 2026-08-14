package com.leetcode.practice._100_Same_Tree;


import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        boolean leftIsSame = isSameTree(p.left, q.left);
        boolean rightIsSame = isSameTree(p.right, q.right);

        return p.val == q.val && leftIsSame && rightIsSame;
    }



}
