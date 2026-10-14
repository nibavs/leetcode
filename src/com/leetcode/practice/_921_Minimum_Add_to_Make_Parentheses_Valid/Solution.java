package com.leetcode.practice._921_Minimum_Add_to_Make_Parentheses_Valid;

public class Solution {
    public int minAddToMakeValid(String s) {
        int open=0;
        int close=0;
        for(char ch:s.toCharArray())
        {
            if(ch=='(')
            {
                open++;
            }
            else{
                if(open>0)open--;
                else close++;
            }
        }
        return open+close;
    }
}
