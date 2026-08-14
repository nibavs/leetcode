package com.leetcode.practice._22_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(n, 0, 0, sb, ans);
        return ans;
    }

    private void dfs(int n, int open, int close, StringBuilder str, List<String> ans) {
        if (str.length() == n * 2) {
            ans.add(str.toString());
            return;
        }

        if (open < n) {
            str.append('(');
            dfs(n, open + 1, close, str, ans);
            str.deleteCharAt(str.length() - 1);
        }

        if (close < open) {
            str.append(')');
            dfs(n, open, close + 1, str, ans);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
