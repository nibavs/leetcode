package com.leetcode.practice._20_Valid_Parentheses;

import java.util.*;

public class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0 || s.isEmpty()) return false;

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')) return false;
            }
        }
        return stack.isEmpty();
    }
}
