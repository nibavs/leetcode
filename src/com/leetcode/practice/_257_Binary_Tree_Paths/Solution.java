package com.leetcode.practice._257_Binary_Tree_Paths;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}

        TreeNode(int x) { val = x; }

    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        rec(ans, root, sb);

        return ans;
    }

    private void rec(List<String> ans, TreeNode root, StringBuilder sb) {
        if (root == null) return;

        int amount = 0;
        if (!sb.isEmpty()) {
            sb.append("->");
            amount = 2;
        }
        amount += Integer.toString(root.val).length();
        sb.append(root.val);

        if (root.left == null && root.right == null) {
            ans.add(sb.toString());
        }

        rec(ans, root.left, sb);
        rec(ans, root.right, sb);

        if (sb.length() < amount) return;
        sb.delete(sb.length() - amount, sb.length());
    }

}
