package com.leetcode.practice._144_Binary_Tree_Preorder_Traversal;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        rec(ans, root);

        return ans;
    }

    private void rec(List<Integer> ans, TreeNode node) {
        if (node == null) return;

        ans.add(node.val);
        rec(ans, node.left);
        rec(ans, node.right);
    }
}
