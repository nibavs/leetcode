package com.leetcode.practice._145_Binary_Tree_Postorder_Traversal;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) return;

        dfs(root.left, ans);
        dfs(root.right, ans);
        ans.add(root.val);
    }
}
